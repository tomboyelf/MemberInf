package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.Product;

public class ProductDAO extends DAO {
	public List<Product> search(String keyword) throws Exception {
		List<Product> list = new ArrayList<>();

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select * from producta where productname like ?");
		st.setString(1, "%" + keyword + "%");
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt("id"));
			p.setProductName(rs.getString("productname"));
			p.setPrice(rs.getInt("price"));
			list.add(p);
		}

		st.close();
		con.close();

		return list;
	}

	public List<Product> showAll() throws Exception {
		List<Product> list = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"select * from producta");
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt("id"));
			p.setProductName(rs.getString("productname"));
			p.setPrice(rs.getInt("price"));
			list.add(p);
		}
		st.close();
		con.close();

		return list;
	}

	public int insert(Product product) throws Exception {
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"insert into producta values(null, ?, ?)");
		st.setString(1, product.getProductName());
		st.setInt(2, product.getPrice());
		int line = st.executeUpdate();

		st.close();
		con.close();
		return line;

	}
}
