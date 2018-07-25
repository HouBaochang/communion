<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<!-- 	<link rel="stylesheet" type="text/css" href="login.css"> -->
<style type="text/css">
    .jx{text-align:center;
	margin-top:30px;
	font-size:50px;
	color:black;}
	.center{
	margin-top:50px;
	}
	.biao{
	 text-align:center;
	 border:3px solid ;
	 width:500px;
	 color:black;
	 font-size:20px;
	 padding:50px 20px;
	}
    .biaoti{
	 text-align:center;
	 margin:30px auto;
	 font-size:23px;
	 color:black;
    }
	.biaotou{
	 width:25%;
	 height:45px; 
	}
	.neirong{
	width:75%;
	height:45px;
	color:black;
	}
	a {text-decoration: none;}
	.btn,.xg,.btnt{
	font-size:20px;     
	color:black; 
	display:inline-block;    
	width:100px;        
	height:30px;         
	line-height:30px;   
	border:1px solid #FCFCFC;
	text-align:center;
	
	 font-size:20px;
	background-color: #FCFCFC; 
	background:white;
	}  
	.btn:hover,.xg:hover,.btnt:hover{
	background:red;
	}
	.biaoti{
	text-align:center;
	margin:30px auto;
	font-size:30px;
	color:black;
	}
	input,select{
	width:90%;
	height:28px;
	color:black;
	border:1px solid #FCFCFC ;
	background:rgba(0,0,0,0);
	}
	#tishi{
	text-align:center;  
	margin-top:30px;
	font-size:20px;
	color:red;
	}
 	
</style>
		<script src="jquery-1.11.3.min.js"></script>
		<script type="text/javascript">
			$(function(){ 
			    //“登录”的单击动作
				$(".btn").bind("click",function(){  
				       //验证账号
				       var username=$("#username");
				       if($.trim(username.val()).length==0){
				            $("#tishi").html("账号不能为空！");
				            username.focus();
				            return;
				       }else{
				            $("#tishi").html("");
				       }
				       //验证账号
				       var password=$("#password");
				       if($.trim(password.val()).length==0){
				            $("#tishi").html("密码不能为空！");
				            password.focus();
				            return;
				       }else{
				            $("#tishi").html("");
				       }
				       
				       //验证通过后，用AJAX提交请求
				       $.ajax({
		
						     type: 'POST',
						     url: 'ajaxProcess.jsp' ,
						     data: {
						        username:$.trim(username.val()),
						        password:$.trim(password.val())
						     },
						     success: function(data) {
						          //data代表服务端返回的数据

						          if($.trim(data)=="1"){//登录成功，跳转到系统主页
						               location.href="admin.jsp";
						          }
						          if($.trim(data)=="2"){//登录成功，跳转到系统主页
						               location.href="student.jsp";
						          }
						           if($.trim(data)=="3"){//登录成功，跳转到系统主页
						               location.href="teacher.jsp";
						          }
						          else{//登录失败
						               $("#tishi").html("用户名或密码错误");
						          }   
						     }
						}); 
				});  
			}); 
       </script>
  </head>
  <body>
    <div class="jx"><p>信商师生交流系统</p></div>
    <div class="center">
    <table align="center" width="600" border="0" cellpadding="0" cellspacing="0" class="biao">	
	              <tr>
					<td class="biaoti" colspan="2">
					    <p>用户登录</p>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou">账号：</td>
					<td class="neirong">
					    <input id="username" name="username" type="text"/>
					</td>
	              </tr>
				  <tr>
					<td class="biaotou">密码：</td>
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
					    <a href="javascript:void(0);" class="btn">登&nbsp;录</a>					    
					</td>
	              </tr>	
		</table>	
        <!-- 提示信息显示区 -->
        <div id="tishi"></div>	
    </div>
  </body>
</html>
