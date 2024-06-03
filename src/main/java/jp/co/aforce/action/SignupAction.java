package jp.co.aforce.action;

import java.io.PrintWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.dao.CustomerDAO;
import jp.co.aforce.tool.Action;

public class SignupAction extends Action {
	public String execute(
				HttpServletRequest request, HttpServletResponse response
			) throws Exception{
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		response.setContentType("text/html; charset=UTF-8");
//		Date date=new Date();
		
		
		String username=request.getParameter("username");
		String pass=request.getParameter("pass");
		String lastname=request.getParameter("lastname");
		String firstname=request.getParameter("firstname");
		String sex=request.getParameter("sex");
		String birth=request.getParameter("birth");
		String mail=request.getParameter("mail");
		int phone=Integer.parseInt(request.getParameter("phone"));
		
		
		CustomerDAO dao=new CustomerDAO();
//		Customer c=new Customer(username, pass, lastname, firstname, sex, birth, mail, phone);
		try {
			dao.insert(username, pass, lastname, firstname, sex, birth, mail, phone);
//			if(line==1) {
//				return "signup-ok.jsp";
//			} 
//			String msg="登録に失敗しました。パスワードは4文字以上で入力してください。";
//			request.setAttribute("signupMsg", msg);
			return "singup-ok.jsp";
		} catch(Exception e) {
			String signupError="ユーザーネーム、メールアドレス、電話番号のいずれかがすでに登録されています。";
			request.setAttribute("signupError", signupError);
			return "index.jsp";
		}
	}

}
