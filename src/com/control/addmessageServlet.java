package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BaseDAO;
import com.util.JDBCUtil;

public class addmessageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html;charset=utf-8");
	    String mtitle1=request.getParameter("mtitle");
	    String mtitle=new String(mtitle1.getBytes("iso-8859-1"),"utf-8");
        String tnames=request.getParameter("tname");
        String tname=new String(tnames.getBytes("iso-8859-1"),"utf-8");
        String text1=request.getParameter("text");
        String text=new String(text1.getBytes("iso-8859-1"),"utf-8");
        String sname1=request.getParameter("sname");
        String sname=new String(sname1.getBytes("iso-8859-1"),"utf-8");
        
        System.out.println(sname);
        System.out.println(tname);
        System.out.println(text);
        System.out.println(mtitle);
        BaseDAO dao=new BaseDAO();
       // boolean status=dao.addmessage(mtitle,tname,text,sname);
        boolean status=dao.addmessage(mtitle,tname,text,sname);
        response.setContentType("text/html;charset=utf-8");
        //设置Servlet返回数据的编码为“UTF-8”
        String sql="insert into message(mtitle,tname,text,sname)values("+mtitle+","+tname+","+text+","+sname+")";
		PrintWriter out = response.getWriter();
        if(status==true){
        	out.println("1");
        }else{
        	out.println("0");
        }
		out.flush();
		out.close();
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}
}
