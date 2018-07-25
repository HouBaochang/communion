<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
     String spsw=(String)session.getAttribute("spsw");
       String studentid=(String)session.getAttribute("studentid");
       System.out.println(studentid);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'sure.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<!--     <link rel="stylesheet" type="text/css" href="login.css"> -->
	<script src="jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
	  	$(function(){ 
	  	
	  	
		  $(".btn").bind("click",function(){  
				   //验证旧密码
		   var oldpsw=$("#oldpsw");
		   if($.trim(oldpsw.val()).length==0){
				$("#tishi").html("原密码不能为空！");
				oldpsw.focus();
				return;
		   }else{
				$("#tishi").html("");
		   }
		   //新密码
		   var newpsw=$("#newpsw");
		   if($.trim(newpsw.val()).length==0){
				$("#tishi").html("新密码不能为空！");
				newpsw.focus();
				return;
		   }else{
				$("#tishi").html("");
		   }
		   //确认新密码
		   var snewpsw=$("#snewpsw");
		   if($.trim(snewpsw.val()).length==0){
				$("#tishi").html("确认新密码不能为空！");
				snewpsw.focus();
				return;
		   }else{
				$("#tishi").html("");
		   }
		   var spsw=<%=spsw%>;
		   if(oldpsw.val().toString()!=spsw){
		   		$("#tishi").html("原密码输入错误！");
		   		return;
		   }else{
				$("#tishi").html("");
		   }
		   if(newpsw.val()!=snewpsw.val()){
		   		$("#tishi").html("两次密码不一样！");
		   		return;
		   }else{
				$("#tishi").html("");
		   }
		   //验证通过后，用AJAX提交请求
		   $.ajax({
				 type: 'GET',
				 url:"updatestupswServlet",
				 data: {
				     oldpsw:oldpsw.val(),
				     newpsw:newpsw.val()

				 },
				 success: function(data) {
				alter(oldpsw);
				alter(newpsw);
					  //data代表服务端返回的数据
					  if($.trim(data)=="1"){//添加成功
							//设置提示信息为绿色
							$("#tishi").css("color","#fff");
							$("#tishi").html("修改密码成功");    
							setTimeout('updateAdminPwdPage()',5000);
					  }else{//添加失败	
						   $("#tishi").html("修改密码失败"); 
					  }   
				 }
			});		
	});//2
}); //1




function updateAdminPwdPage(){
		window.location='student.jsp';
}
  </script>
  </head>
  
  <body id="bc">
		<table align="center" width="600" border="0" cellpadding="0" cellspacing="0" class="biao">	
	              <tr>
					<td class="biaoti" colspan="2">
					    <p>修改密码</p>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">旧密码：</td>
					<td class="neirong">
					    <input id="oldpsw" name=oldpsw" type="password" value="${r.oldpsw}"/>
					</td>
	              </tr>
				  <tr>
					<td class="biaotou">新密码：</td>
					<td class="neirong">
					    <input id="newpsw" name="newpsw" type="password" value="${r.newpsw}"/>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">确认密码：</td>
					<td class="neirong">
					    <input id="snewpsw" name="snewpsw" type="password" value="${r.snewpsw}"/>
					</td>
	              </tr>
				  <tr>
					<td class="neirong" colspan="2">
					    <a href="javascript:void(0);" align="center">确&nbsp;认</a>					    
					</td>
	              </tr>	
		</table>	
		<!-- 提示信息显示区 -->
        <div id="tishi"></div>	
  </body>
</html>
