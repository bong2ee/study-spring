package kr.co.ezenac.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {
	
	public static void makeCookie(HttpServletResponse response, String cName, String cValue, int cTime) {
		Cookie cookie = new Cookie(cName, cValue);	//쿠키 생성
		cookie.setPath("/");			//경로 설정
		cookie.setMaxAge(cTime);								//유지 기간 설정 (1분)
		response.addCookie(cookie);
		
	}
 
	
	public static void deleteCookie(HttpServletResponse response, String cName) {
		makeCookie(response,cName,"",0);
	}
	
	public static String readCookie(HttpServletRequest request, String cName) {
		String cookieValue = "";
		      Cookie[] cookies = request.getCookies();      // 요청 헤더의 모든 쿠키
		      if(cookies != null) {
		      for(Cookie c : cookies){
		         String cookieName = c.getName();
		         if(cookieName.equals(cName)) {
		        	cookieValue = c.getValue();
		         }
		      }
		   }
		return cookieValue;
	}
	
}
