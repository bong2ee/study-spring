<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="IsErrorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=dege">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>page 지시어 - errorPage, isErrorPage 속성</title>
</head>
<body>
	<%
      
         int myAge = Integer.parseInt(request.getParameter("age")) + 10; // 에러 발생
         out.println("추가된 년수가 "+myAge+"입니다.");   // 실행되지 않음
      
    %>
</body>
</html>