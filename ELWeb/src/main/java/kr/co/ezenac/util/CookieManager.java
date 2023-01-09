package kr.co.ezenac.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {
	
	public static void makeCookie(HttpServletResponse response, String cName, String cValue, int cTime) {
		//쿠키 생성
		Cookie cookie = new Cookie(cName, cValue);
		//경로 설정 
		cookie.setPath("/");
		cookie.setMaxAge(cTime);
		response.addCookie(cookie);
	}

}
