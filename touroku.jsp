
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
<title>会員登録</title>
</head>
<body>
	<h1>会員登録</h1>

	<!-- エラーがある気の処理を記載する -->
	<%
		String[] errorMessages = (String[]) request.getAttribute("errorMessages");
		if (errorMessages != null) {
	%>
	<ul>
		<%
			for (int i = 0; i < errorMessages.length; i++) {
					if (errorMessages[i] != null) {
		%>
		<li><%=errorMessages[i]%></li>
		<%
			}
				}
		%>
	</ul>
	<%
		}
	%>
	<form method="post" action="/Stady/Sinnki">
		<table>
			<tr>
				<td>氏名</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>電話番号（携帯）</td>
				<td><input type="text" name="cellphoneNumber"  placeholder="(例)090-####-####"></td>
			</tr>
			<tr>
				<td>メールアドレス</td>
				<td><input type="text" name="mail"></td>
			</tr>
			<tr>
				<td>パスワード</td>
				<td><input type="text" name="password" placeholder="半角数字の組み合わせ"></td>
			</tr>
			<tr>
				<td>性別</td>
				<td><input type="radio" name="gender" value="男性">男性&nbsp;
					<input type="radio" name="gender" value="女性">女性</td>
			</tr>
			<tr>
				<td>年齢</td>
				<td><select name="age">
						<option value="none">■選択してください</option>
						<option value="10代">10代</option>
						<option value="20代">20代</option>
						<option value="30代">30代</option>
						<option value="40代">40代</option>
						<option value="50代">50代</option>
						<option value="60代以上">60代以上</option>
				</select></td>
			</tr>
			<tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="登録"></td>
			</tr>
		</table>
	</form>
</body>
</html>