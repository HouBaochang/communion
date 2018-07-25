<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- <link rel="stylesheet" type="text/css" href="login.css"> -->
<script src="jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="add.js"> </script>
</head>
<body id="bc">
     <table align="center" width="600" border="0" cellpadding="0" cellspacing="0" class="biao">	
	              <tr>
					<td class="biaoti" colspan="2">
					    <p >添加教师</p>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">学号：</td>
					<td class="neirong">
					    <input id="tno" name="tno" type="text" value="${r.tno}"/>
					</td>
	              </tr>
				  <tr>
					<td class="biaotou">密码：</td>
					<td class="neirong">
					    <input id="tpsw" name="tpsw" type="password" value="${r.tpsw}"/>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">姓名：</td>
					<td class="neirong">
					    <input id="tname" name="tname" type="text" value="${r.tname}"/>
					</td>
	              </tr>
				  <tr>
					<td class="neirong" colspan="2">
					 <input type="hidden" id="studentid" name="studentid" value=${r.studentid}>
					    <a href="javascript:void(0);" class="btnt">保&nbsp;存</a>					    
					</td>
	              </tr>	
		</table>
		
  </body>
</html>