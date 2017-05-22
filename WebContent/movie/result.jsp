<%@page contentType="text/html;charset=utf-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
<%
	String msg = (String)request.getAttribute("data");
%>
<%=msg %>
</body>
</html>