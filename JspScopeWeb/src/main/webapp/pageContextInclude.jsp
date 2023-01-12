<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=dege">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>page 영역</title>
</head>
<body>
	<h1>Include 페이지</h1>
	<%
		int pInteger2 = (Integer)pageContext.getAttribute("ezenInteger");
	%>
	
	<ul>
		<il>Integer 객체 : <%=pInteger2 %></il>
	</ul>
</body>
</html>