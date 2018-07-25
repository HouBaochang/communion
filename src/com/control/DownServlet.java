package com.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8"); 
	 	 // 1.��������ļ�����·��
	 	 String fileName = new String(request.getParameter("wjname").getBytes("iso8859-1"),"utf-8");
	 	 String filePath = "\\ziliao\\" + fileName;
//	 	 System.out.println(fileName);
	 	 // 2.�����ļ�MIME���ͣ�ָ��Ҫ�������ݵ����ͣ�
	 	 response.setContentType(getServletContext().getMimeType(fileName));
	 	 // 3.����Content-Disposition��ָ�����ظ��ļ�ʱ���ļ�����
	 	 //java.net.URLEncoder.encode(fileName, "UTF-8")��ֹ������е��ļ�����������
	 	 response.setHeader("content-disposition", "attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
	 	 // 4.��ȡĿ���ļ���ͨ��response��Ŀ���ļ�д���ͻ���
	 	 // 4.1 ��ȡĿ���ļ��ľ���·��
	 	 filePath = this.getServletContext().getRealPath(filePath);
	 	 // 4.2 ��ȡ�ļ�
	 	 InputStream in = new FileInputStream(filePath);
	 	 // 4.3 ����ļ�
	 	 OutputStream out = response.getOutputStream();
	 	 // д�ļ�
	 	 int n;
	 	 while ((n = in.read()) != -1) {
	 	  out.write(n);
	 	 }
	 	 
	 	 in.close();
	 	 out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
