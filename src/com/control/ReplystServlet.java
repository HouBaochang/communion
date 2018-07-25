package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.BaseDAO;

public class ReplystServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	       String tname1=request.getParameter("tname");
	       String tname=new String(tname1.getBytes("iso-8859-1"),"utf-8");
	       String mtitle1=request.getParameter("mtitle");
	       String mtitle=new String(mtitle1.getBytes("iso-8859-1"),"utf-8");
	       String text1=request.getParameter("text");
	       String text=new String(text1.getBytes("iso-8859-1"),"utf-8");
	       String answer= new String(request.getParameter("answer").getBytes("iso8859-1"),"utf-8");
	       String titleid=request.getParameter("titleid");
	       System.out.println(tname);
	       System.out.println(mtitle);
	       System.out.println(text);
	       System.out.println(answer);
	       System.out.println(titleid);
//	       System.out.println(tno+" , "+rpcontent+" ! ");
	       //调用ListDAO层通过tno获取教师姓名赋给replier
	      /* BaseDAO Dao=new BaseDAO();
	       List<Map<String,Object>> list=Dao.getTeacher(tno);
	       String replier = (String)list.get(0).get("name");*/
	       //调用AddDao回复
	       BaseDAO dao=new BaseDAO();
	       boolean status=dao.replyly(mtitle,tname,text,answer,titleid);
	       //设置Servlet返回数据的编码为“UTF-8”
	       response.setContentType("text/html;charset=utf-8");
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
		doGet(request, response);
	}
}
