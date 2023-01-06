package kr.co.ezenstation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("LoginController")
public class LoginController {

	@RequestMapping(value = {"/req/loginform.do","/req/loginform2.do"}, method = {RequestMethod.GET})
	public ModelAndView loginform() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/requestmessage/loginform");
		return mav;
	}
	
	@RequestMapping(value = "/req/login.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		
		String requestLine = request.getMethod();		//get 또는 post
		requestLine += request.getRequestURI();
		
		String queryString = request.getQueryString();
		requestLine += queryString == null ? "" : "?"+ queryString;
		requestLine += " " + request.getProtocol();
		System.out.println(requestLine);
		
		Enumeration<String> a = request.getHeaderNames();
	  	while(a.hasMoreElements()){
	       String name = a.nextElement();
	       System.out.println(name + " : " + request.getHeader(name));
	  	}
		
	  	final int CONTENT_LENGTH = request.getContentLength();
	  	System.out.println("content length : " + CONTENT_LENGTH);
	  	   
	  	   if(CONTENT_LENGTH > 0) { 
	  		   try {
				request.setCharacterEncoding("utf-8");
				mav.setViewName("/requestmessage/result");
				
				String userId = request.getParameter("userId");
				String userName = request.getParameter("userName");
				
				mav.addObject("userId", userId);
				mav.addObject("userName", userName);
				
				System.out.println();
				System.out.println("userId = " +userId +"userName = " + userName);
				
			   } catch (IOException e) {e.printStackTrace();}
	  	   }	   
		
		return mav;
	}
}
