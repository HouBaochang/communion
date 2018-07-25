<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String apsw=(String)session.getAttribute("apsw");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<!-- 	<link rel="stylesheet" type="text/css" href="login.css"> -->
	<script src="jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
    $(function(){
			$(".xg").bind("click",function(){
			$.ajax({
			    type: 'post',
			    url: 'sure.jsp',
			    success:function(date){
			    $(".biao").html(date);
			 }
			});
			});
			});
       </script>
  </head>
  
  <body>
    <table align="center" width="800" border="0" cellpadding="0" cellspacing="0" class="biao">	
	              <tr>
					<td class="biaoti" colspan="2">
					    <p class>修改密码</p>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">账号：</td>
					<td class="neirong">
					    <input id="username" name="username" type="text"/>
					</td>
	              </tr>
				  <tr>
					<td class="biaotou">旧密码：</td>
					<td class="neirong">
					    <input id="password" name="password" type="password"/>
					</td>
	              </tr>
	              <tr>
	              <td class="biaotou">角色：</td>
					<td class="neirong">
					   <select  name="role">
				   	  	<option value="学生">学生</option>
				   	  	<option value="教师">教师</option>
				   	  	<option value="教务人员">教务人员</option>
				   	  </select>
					</td>
	              </tr>	
				  <tr>
					<td class="neirong" colspan="2">
                       <a href="javascript:sendAjaxNoParam('UpdatepswServlet?adminid=${r.adminid}','post')" class="xg">确&nbsp;认</a>
					   
					</td>
	              </tr>	
		</table>	
  </body>
</html>
