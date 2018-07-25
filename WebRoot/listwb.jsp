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
    
    <title>My JSP 'listmessage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<!-- 	<link rel="stylesheet" type="text/css" href="success.css"> -->
	
  <style>
  .biao{
  margin-right:200px;
  border-collapse:collapse;}
  .biaotou2,.neirong2{
  width:200px;
  height:50px;
  text-align:center;
  border:1px solid white;
  }
  .biaotou1,.neirong1{
  width:700px;
  height:50px;
  text-align:center;
  border:1px solid white;
  }
  </style>
  <script type="text/javascript">
    /*$(function(){
			$(".answer").bind("click",function(){
			$.ajax({
			    type: 'post',
			    url: 'addmessage.jsp',
			    success:function(data){
			    $(".biao").html(data);
			 }
			 
			});
			});});*/
			function answer(){
		myWindow=window.open('manswer.jsp','','width=800,height=400,top=50,left=300');
        myWindow.document.write(manswer.jsp);
        myWindow.focus();
			}
       </script>
      <script src="jquery-1.11.3.min.js"></script>
  </head>
  
  <body>
   <table align="center" width="900" border="0" cellpadding="0" cellspacing="0" class="biao">	
	              <tr>
					<td class="biaoti" colspan="3">
					    <p style="font-size:25px; text-align:center; height:50px;">查看留言</p>
					</td>
	              </tr>
	              <tr>
	              <td class="biaotou2">标题</td>
					 <td class="biaotou2">类型</td>
				
					<td class="biaotou2">上传人</td>
					<td class="biaotou2">文件名</td>
					
					
					<td class="biaotou2">操作</td>
	              </tr>
	              <c:forEach items="${recordss}" var="r">
				  <tr>
				  <td style="display:none">${r.surl}</td>
					<td class="neirong2">${r.ttitle}</td>
					<td class="neirong2">${r.types}</td>
					
					<td class="neirong2">${r.tname}</td>
					<td class="neirong2">${r.wjname}</td>
					
					<td class="neirong2">
						<a class="down" style="cursor:hand"  href="DownServlet?wjname=${r.wjname }" wjname="${r.wjname}" >下载</a></td>
	              </tr>
	              </c:forEach>
	 </table>             
  </body>
</html>
