package jp.co.aforce.action;

import java.io.PrintWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.beans.Customer;
import jp.co.aforce.dao.CustomerDAO;
import jp.co.aforce.tool.Action;

public class RenameAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		response.setContentType("text/html; charset=UTF-8");
		CustomerDAO dao = new CustomerDAO();

		String rename = request.getParameter("rename");
		//		

		try {
			Customer customer = new Customer();
			customer = (Customer) session.getAttribute("customer");
			
			String newname = dao.rename(customer.getUsername(), rename);
			customer.setUsername(newname);
			session.setAttribute("customer", customer);
			
			return "info.jsp";
		} catch (Exception e) {
			String renameError = "ユーザーネームがすでに登録されています。";
			request.setAttribute("renameError", renameError);
			e.printStackTrace();
			return "info.jsp";
		}
	}

}
