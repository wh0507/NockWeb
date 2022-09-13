<%@page import="sogo.ShohinBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String status = "";
String no = request.getParameter("no");
if (no.equals("3")) {
	status = "登録";
} else if (no.equals("2")) {
	status = "変更";
} else {
	status = "削除";
}

ShohinBean s = (ShohinBean) session.getAttribute("shBean");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css">
<title>商品マスタ</title>
</head>
<body>
	<h1>
		商品<%=status%>
	</h1>
	<p>
		以下の商品を<%=status%>します。 <br>
	<div class="form_button1">
		ＩＤ：<%=s.getId() %><br>
		商品名：<%=s.getName() %><br>
		価格：<%=s.getKakaku() %>円<br>
	</div>
	<br>
	<div class="form_button">
		<form action="/NockWeb/ShohinServlet" method="post">
			<input type="submit" value="<%=status%>">
		</form>
		<form action="menu.jsp" method="get">
			<input type="submit" value="戻る">
		</form>
	</div>
</body>
</html>