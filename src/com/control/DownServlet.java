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
	 	 // 1.获得请求文件名及路径
	 	 String fileName = new String(request.getParameter("wjname").getBytes("iso8859-1"),"utf-8");
	 	 String filePath = "\\ziliao\\" + fileName;
//	 	 System.out.println(fileName);
	 	 // 2.设置文件MIME类型（指定要返回内容的类型）
	 	 response.setContentType(getServletContext().getMimeType(fileName));
	 	 // 3.设置Content-Disposition（指定下载该文件时的文件名）
	 	 //java.net.URLEncoder.encode(fileName, "UTF-8")防止保存框中的文件名中文乱码
	 	 response.setHeader("content-disposition", "attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
	 	 // 4.读取目标文件，通过response将目标文件写到客户端
	 	 // 4.1 获取目标文件的绝对路径
	 	 filePath = this.getServletContext().getRealPath(filePath);
	 	 // 4.2 读取文件
	 	 InputStream in = new FileInputStream(filePath);
	 	 // 4.3 输出文件
	 	 OutputStream out = response.getOutputStream();
	 	 // 写文件
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
