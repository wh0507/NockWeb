<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String no = request.getParameter("no");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css">
<title>商品マスタ</title>
</head>
<body>
	<h1>商品一覧</h1>
	<table>
		<tr>
			<%if (no.equals("2")) {%>
			<th></th>
			<%}%>
			<th>ID</th>
			<th>商品名</th>
			<th>価格</th>
		</tr>
		<tr>
			<%if (no.equals("2")) {%>
			<td><input type="radio"></td>
			<%}%>
			<td>00001</td>
			<td>りんご</td>
			<td>100円</td>
		</tr>
		<tr>
			<%if (no.equals("2")) {%>
			<td><input type="radio"></td>
			<%}%>
			<td>00002</td>
			<td>オレンジ</td>
			<td>50円</td>
		</tr>
		<tr>
			<%if (no.equals("2")) {%>
			<td><input type="radio"></td>
			<%}%>
			<td>00003</td>
			<td>メロン</td>
			<td>1200円</td>
		</tr>
	</table>
	<p></p>
	<div class="form_button">
		<%
		if (no.equals("2")) {
		%>
		<form action="mod.jsp?no=<%=no%>" method="POST">
			<input type="submit" value="変更">
		</form>
		<form action="kakunin.jsp?no=4" method="POST">
			<input type="submit" value="削除">
		</form>
		<%}%>
		<form action="menu.jsp" method="GET">
			<input type="submit" value="戻る">
		</form>
	</div>
</body>
</html>