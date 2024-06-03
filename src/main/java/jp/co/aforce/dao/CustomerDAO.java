package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.Customer;

public class CustomerDAO extends DAO {

	public Customer search(String username, String password) throws Exception {

		Customer customer = null;

		Connection con = getConnection();

		PreparedStatement st;
		//		?はプレースホルダ
		st = con.prepareStatement(
				"select * from users where username=? and password=?");
		st.setString(1, username);
		st.setString(2, password);
		//		List<Customer>型へ変換
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			customer = new Customer(rs.getInt("users_id"), rs.getString("username"), rs.getString("password"),
					rs.getString("last_name"), rs.getString("first_name"), rs.getString("sex"),
					rs.getString("birth_date"), rs.getString("mail_address"), rs.getInt("phone_number"));
		}

		st.close();
		con.close();

		return customer;
	}

	//	public int insert(Customer customer) throws Exception {
	public int insert(String username, String password, String lastname, String firstname, String sex, String birth,
			String mail, int phone) throws Exception {
		//		if (password.length() < 4) {
		//			int line = 2;
		//			return line;
		//		}

		Connection con = getConnection();
		PreparedStatement st;
		st = con.prepareStatement(
				"insert into users values(null, ?, ?, ?, ?, ?, ?, ?, ?)");
		st.setString(1, username);
		st.setString(2, password);
		st.setString(3, lastname);
		st.setString(4, firstname);
		st.setString(5, sex);
		st.setString(6, birth);
		st.setInt(7, phone);
		st.setString(8, mail);
		int line = st.executeUpdate();
		st.close();
		con.close();
		return line;
	}

	public String rename(String oldname, String newname) throws Exception {
		Connection con = getConnection();
		PreparedStatement st;
		st = con.prepareStatement(
				"UPDATE users SET username = ? WHERE username = ?;");
		st.setString(1, newname);
		st.setString(2, oldname);
		st.executeUpdate();
		//		ResultSet rs = st.executeQuery();
//		String newname = newname;

		st.close();
		con.close();
		return newname;

		//		int line = 2;
		//		st.close();
		//		con.close();
		//		return line;
	}

	//	public List<Customer> showAll() throws Exception {
	//		List<Customer> allList = new ArrayList();
	//		Connection con = getConnection();
	//		PreparedStatement st;
	//
	//		st = con.prepareStatement(
	//				"select * from login");
	//
	//		ResultSet rs = st.executeQuery();
	//		while (rs.next()) {
	//			Customer customer = new Customer(rs.getInt("id"), rs.getString("login"), rs.getString("password"));
	//			allList.add(customer);
	//		}
	//
	//		st.close();
	//		con.close();
	//
	//		return allList;
	//	}
	//
	//	public int deleteAcc(int id) throws Exception {
	//		Connection con = getConnection();
	//		PreparedStatement st;
	//
	//		st = con.prepareStatement(
	//				"delete from login where id=?");
	//		st.setInt(1, id);
	//		int line = st.executeUpdate();
	//
	//		st.close();
	//		con.close();
	//		return line;
	//	}
}
