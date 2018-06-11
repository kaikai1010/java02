<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ツイッターもどき</title>
</head>
<body>

<h1>トップページ</h1>

<form action="/twitter-like/LoginServlet" method="post">
<table>
<tr>
<th>名前</th>
<td><input type="text" name="name"></td>
</tr>
<tr>
<th>パスワード</th>
<td><input type="password" name="pass"></td>
</tr>
</table>
<br>
<input type="submit" value="ログイン">
</form>

</body>
</html>