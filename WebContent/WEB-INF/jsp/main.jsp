<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.User, model.Twitter, java.util.List" %>

<%
User u = (User) session.getAttribute("u");
@SuppressWarnings("unchecked")
List<Twitter> tList = (List<Twitter>) application.getAttribute("tList");
String errorMsg = (String) request.getAttribute("errorMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ツイッターもどき</title>
</head>
<body>

<h1>メインページ</h1>

<p><%= u.getName() %>さん、ログイン中。 <a href="/twitter-like/MainServlet">ログアウトする</a></p>
<a href="/twitter-like/LoginServlet">更新する</a>

<form action="/twitter-like/MainServlet" method="post">
<input type="text" name="text">
<br>
<input type="submit" value="つぶやく">
</form>

<% if(errorMsg != null && errorMsg.length() != 0) { %>
<p><%= errorMsg %></p>
<% } %>

<% for(Twitter t : tList) { %>
<p><%= t.getTwitterName() %>さん: <%= t.getText() %></p>
<% } %>

</body>
</html>