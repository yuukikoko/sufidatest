<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	Cookie cookies[] = request.getCookies();
	Cookie targetCookie = null;

	String[] pieces = null;
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("item")) {
				targetCookie = cookies[i];
			}
		}
	}
	if (targetCookie != null) {
		pieces = targetCookie.getValue().split(",");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>カート</title>
</head>
<body>

	<ul>
		<li><a href="/Stady/itemlist.html">買い物を続ける</a></li>
	</ul>
	<%
		if (pieces == null || pieces[0].length() == 0) {
	%>
	<p>カートは空です。</p>
	<%
		} else {
	%>
	<table>
		<tr>
			<td>商品</td>
			<td>&nbsp;</td>
		</tr>
		<%
			for (int i = 0; i < pieces.length; i++) {
		%>
		<tr>
			<td><%=pieces[i]%></td>
			<td><a href="/Stady/RemoveItem?item=<%=pieces[i]%>">削除</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		}
	%>
</body>
</html>