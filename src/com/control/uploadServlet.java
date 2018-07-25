package com.control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.BaseDAO;



public class uploadServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tnames = null;
		String ttitle = null;
		String types = null;
		String surl = null;
		String message = "";
		try {
			// 使用Apache文件上传组件处理文件上传步骤：
			// 1、创建一个DiskFileItemFactory工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 2、创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解决上传文件名的中文乱码
			upload.setHeaderEncoding("UTF-8");
			// 3、判断提交上来的数据是否是上传表单的数据
			if (!ServletFileUpload.isMultipartContent(request)) {
				// 按照传统方式获取数据
				return;
			}
			// 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			List<FileItem> list = upload.parseRequest(request);
			//获取数据
			for (FileItem item : list) {
				// 如果fileitem中封装的是普通输入项的数据
				if (item.isFormField()) {
						String name = item.getFieldName();//获取表单项的name
						if(name.equals("tnames")){
							tnames= item.getString("UTF-8");//取出上传者姓名
						System.out.println(tnames);
						}else if(name.equals("ttitle")){
							 ttitle= item.getString("UTF-8");//取出上传者工号
						}else if(name.equals("types")){
							 types = item.getString("UTF-8");//取出上传文件类型
						}
				// 如果fileitem中封装的是上传文件
				} else {
					// 得到上传的文件名称，
					String wjname = item.getName();
					// 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
					int index = wjname.indexOf("\\");
					if(index!=-1){
						wjname = wjname.substring(index+1);
					}
					//上传路径
					String path = "/ziliao/";
					surl = this.getServletContext().getRealPath(path+wjname);
					System.out.println(surl+".....");
					System.out.println(wjname);
					System.out.println(tnames);
					File file = new File(surl);
					if(!file.exists()){
						file.getParentFile().mkdirs();//创建上层目录
					}
					//保存
					item.write(file);
					//将信息传入数据库
					BaseDAO dao = new BaseDAO();
					if(dao.addZiliao(wjname,surl,tnames,ttitle,types)){
						if(types.equals("video")){
							message="上传视频成功";
							request.setAttribute("message", message);
						}else{
							message="上传试题成功";
							request.setAttribute("message", message);
						}
					}else{
						message="上传文件失败";
						request.setAttribute("message", message);
					}
		request.getRequestDispatcher("message.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			message = "文件上传失败！";
			System.out.println(message);
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
