<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.html"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<c:choose>
	<c:when test="${customer != null }">
		<p>${customer.username}さんでログイン中</p>
		<p>
			<a href="/MemberInformation/views/info.jsp">会員情報</a>
		</p>
		<p>
			<a href="Logout.action">ログアウト</a>
		</p>
	</c:when>
	<c:when test="${customer == null }">
		<p>${loginError}</p>
		<form action="Login.action" method="post">
			ユーザー名<input type="text" name="username" value="${username }" required><br>
			パスワード<input type="password" name="pass" required><br> <input
				type="submit" value="ログイン">
		</form>
		<p>
			<a href="/MemberInformation/views/index.jsp">会員登録が済んでいない人はこちら</a>
		</p>
	</c:when>
	<c:otherwise>
		<p>おしまい</p>
	</c:otherwise>
</c:choose>
<%@include file="../footer.html" %>