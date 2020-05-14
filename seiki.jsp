<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>確認ページ</title>

<!-- キャッシュの無効 -->
<%
response.setHeader("pragma", "no-cache");
response.setHeader("Cache-Control", "no-cache");
response.setDateHeader("Expires", 0);
%>

</head>
<body>
	<h1>確認ページ</h1>

<p>以下の内容で登録ができました。</p>

	<table>
		<tr>
			<td>お名前</td>
			<td>${param.name}</td>
		</tr>
		<tr>
			<td>パスワード</td>
			<td>●●●●●●</td>
		</tr>
		<tr>
			<td>メールアドレス</td>
			<td>${param.mail}</td>
		</tr>

		<tr>
			<td>電話番号（携帯）</td>
			<td>${param.cellphoneNumber}</td>
		</tr>

		<tr>
			<td>性別</td>
			<td>${param.gender}</td>
		</tr>
		<tr>
			<td>年齢</td>
			<td>${param.age}</td>
		</tr>
		<tr>
		<tr>
			<td>入力して頂いたメールにて内容確認メールを送信します</td>
		</tr>
		<tr>
			<td><input type="submit" value="送信"></td>
		</tr>

	</table>
</body>
</html>