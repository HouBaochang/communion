package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BaseDAO;

public class updatestudentServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	      this.doPost(request, response);
		}
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			HttpSession session=request.getSession();
		    //���е�¼ҳ��֤����ֹû�е�¼ֱ�ӽ����ҳ��
		    String sno=(String)session.getAttribute("username");
		    if(sno!=null && !sno.equals("")){
		    	request.setCharacterEncoding("utf-8");
		        String spsw=request.getParameter("spsw");
		        String sname=request.getParameter("sname");
		        String studentid=request.getParameter("studentid");

		        
		        //����DAO��
		        BaseDAO dao=new BaseDAO();
		        boolean status=dao.updateOne("student","sno='"+sno+"',spsw='"+spsw+"',sname='"+sname+"' where studentid="+studentid);

		        
		        
		        //����Servlet�������ݵı���Ϊ��UTF-8��
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
			
			
		}

	}
