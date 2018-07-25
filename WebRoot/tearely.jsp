<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>教师回复</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  <style type="text/css">
  
  .biao{
  margin-right:200px;
  border-collapse:collapse;
  }
  .biaotou2,.neirong2{
  width:200px;
  height:50px;
  text-align:center;
  border:1px solid white;
  }
 
  
  </style>
  <body>
    	<div>
       <table align="center" width="80%"  border="0" cellpadding="0"  cellspacing="0" class="biao">	
	               <tr>
					<td class="biaoti" colspan="3">
					    <p style="font-size:25px; text-align:center; height:50px;">历史留言</p>
					</td>
	              </tr>
	              <tr height="50px">
	                 <td class="biaotou2" width="20%">标题</td> 
	                <td class="biaotou2" width="20%">提问内容</td>   
	                <td class="biaotou2" width="30%">回复内容</td> 
	              </tr>
	              <c:forEach items= "${requestScope.list}"  var="r">
				  <tr height="50px">
					<td class="neirong2">${r.mtitle}</td>
					<td class="neirong2">${r.text}</td>
					<td class="neirong2">${r.answer}</td>					
	              </tr>
				 </c:forEach>
		</table>
		</div>
  </body>
</html>
