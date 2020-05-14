<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- キャッシュの無効 -->
<%
response.setHeader("pragma", "no-cache");
response.setHeader("Cache-Control", "no-cache");
response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会員限定サイト</title>
</head>
<body>
	<h1>会員限定サイト</h1>

<p>ログインが成功しました</p>


</body>
</html>