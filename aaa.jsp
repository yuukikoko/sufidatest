<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List"
	import="java.util.ListIterator" import="jp.bean.com.ResBean"
	import="jp.util.com.Cast"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
h1 {
	text-align: center;
	margin: 0 auto;
}

.form {
	text-align: center;
}
</style>
<title>お問い合わせ</title>
</head>
<body>
	<h1>お問い合わせ</h1>
	<div class="form">
		<form method="post" action="Stady/Controller">
			<table>
				<thead>
					<tr>
						<td>名前</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>タイトル</td>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<td>内容</td>
						<td><textarea name="contents"></textarea></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="書き込む"></td>
					</tr>
			</table>
		</form>
	</div>
	<hr>
	<%
		List<ResBean> list = (List<ResBean>) session.getAttribute("list");
		if (list != null) {
			ListIterator<ResBean> iterator = list.listIterator(list.size());
			while (iterator.hasPrevious()) {
				ResBean res = iterator.previous();
	%>
	<p>
		名前：<%=res.getName()%></p>
	<p>
		題名：<%=res.getTitle()%></p>
	<p>
		内容：<%=res.getContents()%></p>
	<hr>
	<%
		}
		}
	%>
</body>
</html>