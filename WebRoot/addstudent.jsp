<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <% 
// BaseDAO dao=new BaseDAO();
//Map<String,Object> data=dao.getAll("*", "student", "", "studentid desc", 0, 999);
//  List<Map<String,String>> students=(List<Map<String,String>>)data.get("records");
///request.setAttribute("student", students);
//System.out.println(classnames.size());  
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'addstudent.jsp' starting page</title>
    <meta name="content-type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- <link rel="stylesheet" type="text/css" href="login.css">  -->
	<script src="jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="add.js"> </script>	
  </head>
  
  <body id="bc">
     <table align="center" width="600" border="0" cellpadding="0" cellspacing="0" class="biao">	
	              <tr>
					<td class="biaoti" colspan="2">
					    <p >添加学生</p>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">学号：</td>
					<td class="neirong">
					    <input id="sno" name="sno" type="text" value="${r.sno}"/>
					</td>
	              </tr>
				  <tr>
					<td class="biaotou">密码：</td>
					<td class="neirong">
					    <input id="spsw" name="spsw" type="password" value="${r.spsw}"/>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">姓名：</td>
					<td class="neirong">
					    <input id="sname" name="sname" type="text" value="${r.sname}"/>
					</td>
	              </tr>
				  <tr>
					<td class="neirong" colspan="2">
					    <a href="javascript:void(0);" class="btn">保&nbsp;存</a>					    
					</td>
	              </tr>	
		</table>
	
		
		
			
  </body>
</html>
