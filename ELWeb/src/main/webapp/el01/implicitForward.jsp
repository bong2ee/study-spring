<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=dege">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
</head>
<body>
	<h2>implicitForward 페이지</h2>
	<h3>각 영역에 조장된 속성 읽기</h3>
	<ul>
		<li>페이지 영역 : ${pageScope.scopeValue}</li>
		<li>리퀘스트 영역 : ${requestScope.scopeValue }</li>		
		<li>세션 영역 : ${sessionScope.scopeValue }</li>
		<li>애플리케이션 영역 : ${applicationScope.scopeValue }</li>
	</ul>
</body>
</html>