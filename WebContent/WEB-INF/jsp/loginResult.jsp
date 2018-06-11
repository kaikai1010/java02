<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.User" %>

<%
User u = (User) session.getAttribute("u");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ツイッターもどき</title>
</head>
<body>

<h1>ログインページ</h1>

<% if(u == null) { %>
<%-- ログイン失敗の場合 --%>
<p>ログインに失敗しました。</p>
<a href="/twitter-like/">トップへ戻る</a>

<% } else {  %>
<%-- ログイン成功の場合 --%>
<p>ログインに成功しました。ようこそ、<%= u.getName() %>さん。</p>
<a href="/twitter-like/LoginServlet">つぶやきを投稿する</a>
<% } %>

</body>
</html>