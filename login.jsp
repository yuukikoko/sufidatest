<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- キャッシュの無効 -->
<%
response.setHeader("pragma", "no-cache");
response.setHeader("Cache-Control", "no-cache");
response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
</head>
<body>
<h1>ログイン</h1>
<!-- ログインかどうかの確認 -->
<ul>
<% if (session.getAttribute("status") == "logout") { %>
<li>ログインに失敗しました。</li>
<% }
session.invalidate(); %>
<li>IDを入力してください。</li>
<li>パスワードを入力してください。</li>
</ul>

<!--POSTにて送信 -->
<form method="post" action="/Stady/Password.java">
<table>
<tr>
<td>メールアドレス</td>
<td><input type="text" name="mail"></td>
</tr>
<tr>
<td>パスワード</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td>&nbsp;</td>
<td><input type="submit" value="ログイン"></td>
</tr>
</table>
</form>
<a href="touroku.jsp">	新規会員登録はこちら</a>
</body>
</html>