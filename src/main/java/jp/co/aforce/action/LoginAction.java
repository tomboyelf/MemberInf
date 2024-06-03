package jp.co.aforce.action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.beans.Customer;
import jp.co.aforce.dao.CustomerDAO;
import jp.co.aforce.tool.Action;

public class LoginAction extends Action{
	public String execute(
				HttpServletRequest request, HttpServletResponse response
			) throws Exception{
//		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		CustomerDAO dao=new CustomerDAO();
		response.setContentType("text/html; charset=UTF-8");
		
		String username=request.getParameter("username");
		String pass=request.getParameter("pass");
//		String admin="admin";
		
		Customer customer=dao.search(username, pass);
			if(customer.getUsername()==null || customer.getPassword()==null) {
				String loginError="IDもしくはパスワードが違います。";
				request.setAttribute("loginError", loginError);
				request.setAttribute("username", username);
				return "login.jsp";
			}
//			String msg="ようこそ、"+username+"さん";
			String msg2=username+"さんとしてログイン中";
//			request.setAttribute("msg", msg);
			session.setAttribute("msg2", msg2);
			session.setAttribute("customer", customer);
			return "login.jsp";
	}
	
}
