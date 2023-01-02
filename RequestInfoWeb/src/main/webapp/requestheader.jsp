<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 - request</title>
</head>
<body>
	<h2>요청 헤더 정보 출력하기</h2>
	<%
	   Enumeration<String> headers = request.getHeaderNames();
  	   while(headers.hasMoreElements()){
       String headersName = headers.nextElement();
       String headerValue = request.getHeader(headersName);
       out.print("헤더명 : "+ headersName + ", 헤더값 : " + headerValue + "<br/>");}
	%>
</body>
</html>