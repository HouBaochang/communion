package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BaseDAO;

public class addstudentServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
        String sno=request.getParameter("sno");
      int sn= Integer.parseInt(sno);
        String spsw=request.getParameter("spsw");
        String sname=request.getParameter("sname");
       String Sname=new String(sname.getBytes("iso-8859-1"),"utf-8");
        System.out.println(sno);
        //����DAO��
        BaseDAO dao=new BaseDAO();
        boolean status=dao.addOne(sno,spsw,Sname);
        //����Servlet�������ݵı���Ϊ��UTF-8��
        System.out.println("����");
        
		PrintWriter out = response.getWriter();
        if(status==true){
        	out.println("1");
        }else{
        	out.println("0");
        }
		out.flush();
		out.close();
	
	
		 //����doPost�������д���
		
	}
	//����POST����ķ�����ʵ���������ݵı��棩
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		}
	}


