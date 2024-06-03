<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../header.html" %>
<h1>会員情報</h1>
<p>会員番号:${customer.id }</p>
<p>ユーザーネーム:${customer.username }</p>
<a href="/MemberInformation/views/rename.jsp">ユーザー名変更</a>
<p>苗字/名前:${customer.lastname }${customer.firstname }</p>
<p>性別:${customer.sex }</p>
<p>メールアドレス:${customer.mail }</p>
<p>電話番号:${customer.phone }</p>
<p>
<a href="Logout.action">ログアウト</a>
</p>

<%@include file="../footer.html" %>