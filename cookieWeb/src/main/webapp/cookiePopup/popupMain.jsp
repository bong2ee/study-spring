<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>쿠키를 이용한 팝업</title>
   <style type="text/css">
      div#popup{
         position: absolute;
         top: 100px; left: 50px;
         color: yellow;
         width: 300px; height: 100px;
         background-color: blue; 
      }
      div#popup > div{
         position: relative;
         background-color: #ffffff;
         top: 0px;
         border: 1px solid gray;
         padding: 10px;
         color: black;
      }
   </style>
   <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
   <script type="text/javascript">
      $(function() {
         $('#closeBtn').click(function() {
            $('#popup').hide();      // 닫기버튼 누르면 팝업창 숨김 처리
            /* id가 notopenToday이면서 체크된 체크박스의 값을 읽어옴.*/
            let chkVal = $("input:checkbox[id=notopenToday]:checked").val();  //체크 여부
            
            if(chkVal == 1) {
            
            $.ajax({                        //비동기로 요청을 보냄 (다양한 설정값)
               url: "./popupCookie.jsp",         //popupCookie.jsp 파일에
               type: 'get', 
               data: {notopenToday : chkVal},	//notopenToday=chkVal 데이터를 
               dataType: "text",					//응답 데이터의 타입은 일반 텍스트이며
               success: function(resData) {		//요청 성공시
            	   	if(resData != '')			//응답 데이터가 있다면
					location.reload();
			   }
               
            })
            
            }
         })
      })
   </script>
</head>
<body>
   <%
       String popupMode = "on";
   	   Cookie[] cookies = request.getCookies();
   	   if(cookies != null){
   		   for(Cookie c : cookies){
   			   String cookieName = c.getName();
   			   String cookieValue = c.getValue();
   			   
   			   if(cookieName.equals("PopupClose")){
   				   popupMode = cookieValue;
   			   }
   		   }
   	   }
   
	   for(int i=0; i<=10; i++){
	      out.println("현재 팝업창은" + popupMode + " 상태입니다.<br/>");
	   }
	   
	   if(popupMode.equals("on")){
   %>   
      <div id="popup">
         <h2 align="center">앱을 다운받고 사과시계울트라 받아가자~!</h2>
         <div align="right">
            <form action="#" name="popFrm">
            <input type="checkbox" id="notopenToday" value="1"/> 하루 동안 열지 않음
            <input type="button" id="closeBtn" value="닫기"/>
            </form>
         </div>
      </div>
   <%
   }
   
   %>
   
</body>
</html>