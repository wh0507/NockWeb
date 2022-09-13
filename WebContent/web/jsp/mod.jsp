<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String status = null;
String no = request.getParameter("no");
if (no.equals("3")) {
	status = "登録";
} else if (no.equals("2")) {
	status = "変更";
} else {
	status = "削除";
}
//msgリクエスト確認
String msg = (String) request.getAttribute("msg");
if (request.getAttribute("msg") != null) {
	msg = request.getAttribute("msg").toString();
} else {
	msg = "";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css">
<title>商品マスタ</title>
</head>
<body>
	<h1>
		商品<%=status%>
	</h1>
	<p>
		以下の商品を<%=status%>します。宜しいでしょうか？
	</p>
	<div class="modTable">
		<div class="item">
			<form action="/NockWeb/ControlServlet" method="post">
				<table>
					<tr>
						<td>ＩＤ：</td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td>商品名：</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>価格：</td>
						<td><input type="text" name="kakaku">円</td>
					</tr>
				</table>
				<p class = "msg"><%=msg%></p>
				<input type="submit" value="<%=status%>">
				<input type="button" value="戻る" onclick="history.back()">
			</form>
			<!--<form action="./web/jsp/menu.jsp" method="get">
				<input type="submit" value="戻る">
			</form> -->
		</div>
	</div>
</body>
</html>