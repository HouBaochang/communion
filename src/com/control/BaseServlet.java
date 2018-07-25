package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 此Servlet演示了如何把多个功能写到一个Servlet中
 * @author 朱强
 *
 */
public class BaseServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//用来区分是哪个功能
		String act=request.getParameter("act");
		
		//不需要安全验证的功能
		if(act.equals("logout")){//退出
			HttpSession session=request.getSession();
			session.removeAttribute("username");	
		    response.sendRedirect("login.jsp");	
		}else if(act.equals("ttt")){
			
		}
		
		
		HttpSession session=request.getSession();
	    //进行登录页验证，防止没有登录直接进入此页面
	    String username=(String)session.getAttribute("username");
	    if(username!=null && !username.equals("")){
	    	//需要安全验证的功能	
			if(act.equals("xxx")){
				
			}else if(act.equals("fff")){
				
			}
	    	
	    }
		
		
	}

}
