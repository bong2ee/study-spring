package kr.co.ezenweb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMessage {

	@RequestMapping("/requestmessage")
	public void ezen(HttpServletRequest request) {
		String requestLine = request.getMethod();		//get 또는 post
		requestLine += request.getRequestURI();
		
		String queryString = request.getQueryString();  // year=2022
		requestLine += queryString == null ? "" : "?"+ queryString;
		requestLine += " " + request.getProtocol();	    // HTTP/1.1
		System.out.println(requestLine);
		
	    // request header
		Enumeration<String> a = request.getHeaderNames();
	  	while(a.hasMoreElements()){
	       String name = a.nextElement();
	       System.out.println(name + " : " + request.getHeader(name));
	  	}
		
	    // request body -- POST일 때만 해당, GET은 body가 없음
	  	final int CONTENT_LENGTH = request.getContentLength();
	  	System.out.println("content length : " + CONTENT_LENGTH);
	  	   
	  	   if(CONTENT_LENGTH > 0) { 
	  		   byte[] content = new byte[CONTENT_LENGTH];
	  		   
	  		   InputStream in;
	  		   try {
				in = request.getInputStream();
				in.read(content, 0, CONTENT_LENGTH);
				
				System.out.println();
				System.out.println(new String(content, "utf-8"));
			   } catch (IOException e) {e.printStackTrace();}
	  		   
	  	   }
	}
}
