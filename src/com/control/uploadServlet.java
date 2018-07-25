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
			// ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
			// 1������һ��DiskFileItemFactory����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 2������һ���ļ��ϴ�������
			ServletFileUpload upload = new ServletFileUpload(factory);
			// ����ϴ��ļ�������������
			upload.setHeaderEncoding("UTF-8");
			// 3���ж��ύ�����������Ƿ����ϴ���������
			if (!ServletFileUpload.isMultipartContent(request)) {
				// ���մ�ͳ��ʽ��ȡ����
				return;
			}
			// 4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
			List<FileItem> list = upload.parseRequest(request);
			//��ȡ����
			for (FileItem item : list) {
				// ���fileitem�з�װ������ͨ�����������
				if (item.isFormField()) {
						String name = item.getFieldName();//��ȡ�����name
						if(name.equals("tnames")){
							tnames= item.getString("UTF-8");//ȡ���ϴ�������
						System.out.println(tnames);
						}else if(name.equals("ttitle")){
							 ttitle= item.getString("UTF-8");//ȡ���ϴ��߹���
						}else if(name.equals("types")){
							 types = item.getString("UTF-8");//ȡ���ϴ��ļ�����
						}
				// ���fileitem�з�װ�����ϴ��ļ�
				} else {
					// �õ��ϴ����ļ����ƣ�
					String wjname = item.getName();
					// �����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
					int index = wjname.indexOf("\\");
					if(index!=-1){
						wjname = wjname.substring(index+1);
					}
					//�ϴ�·��
					String path = "/ziliao/";
					surl = this.getServletContext().getRealPath(path+wjname);
					System.out.println(surl+".....");
					System.out.println(wjname);
					System.out.println(tnames);
					File file = new File(surl);
					if(!file.exists()){
						file.getParentFile().mkdirs();//�����ϲ�Ŀ¼
					}
					//����
					item.write(file);
					//����Ϣ�������ݿ�
					BaseDAO dao = new BaseDAO();
					if(dao.addZiliao(wjname,surl,tnames,ttitle,types)){
						if(types.equals("video")){
							message="�ϴ���Ƶ�ɹ�";
							request.setAttribute("message", message);
						}else{
							message="�ϴ�����ɹ�";
							request.setAttribute("message", message);
						}
					}else{
						message="�ϴ��ļ�ʧ��";
						request.setAttribute("message", message);
					}
		request.getRequestDispatcher("message.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			message = "�ļ��ϴ�ʧ�ܣ�";
			System.out.println(message);
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
