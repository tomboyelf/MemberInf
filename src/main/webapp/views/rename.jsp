<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>
<h1>ユーザー名変更</h1>
<p>${signupError}</p>
<form action="Rename.action" method="post">
	ユーザーネーム<input type="text" name="rename" required><br>
	<input type="submit" value="変更">
</form>

<%@include file="../footer.html" %>