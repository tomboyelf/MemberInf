<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<h1>登録画面</h1>
<p>${signupError}</p>
<form action="Signup.action" method="post">
	ユーザーネーム<input type="text" name="username" required><br>
	パスワード<input type="password" name="pass" required><br>
	姓<input type="text" name="lastname" required><br>
	名<input type="text" name="firstname" required><br>
	性別<select name="sex">
	<option value="男">男</option>
	<option value="女">女</option>
	</select><br>
	生年月日<input type="date" name="birth" required><br>
	メールアドレス<input type="text" name="mail" required><br>
	電話番号<input type="text" name="phone" required><br>
	<input type="submit" value="登録">
</form>
<a href="/MemberInformation/views/login.jsp">登録済みの人はこちら</a>
<%@include file="../footer.html" %>