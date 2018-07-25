<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'upload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- <link rel="stylesheet" type="text/css" href="styles.css"> -->
	<style type="text/css">
	.biao{
	width:900px;
	font-size:16px;
	border-collapse:collapse;
	margin-right:200px;
	}
	.biaoti{
	font-size:23px;
	height:80px;
	border:1px solid black;
	}
	.biaotou{
	width:15%;
	height:50px;
	text-align:center;
	border:1px solid black;
	}	
	.neirong,.tneirong{
	width:80%;
	height:50px;
	padding:5px;
	text-align:center;
	border:1px solid black;
	}
	.tneirong{
	width:80%;
	height:300px;
	}

	input,select{
	width:90%;
	height:40px;
	}
	option{
	background-color:#43B2E6;
	}
	input,select,textarea{
	border:1px solid #FCFCFC ;
	background:rgba(0,0,0,0);
	font-size:18px;
	color:white;
	}
	  .file {
			    position: relative;
			    display: inline-block;
			    background: #D0EEFF;
			    border: 1px solid black;
			    border-radius: 4px;
			    padding: 4px 12px;
			    overflow: hidden;
			    color: #1E88C7;
			    text-decoration: none;
			    text-indent: 0;
			    line-height: 25px;
			}
			.file input {
			    position: absolute;
			    font-size: 100px;
			    right: 0;
			    top: 0;
			    opacity: 0;
			}
			.file:hover {
			    background: #AADFFD;
			    border-color: #78C3F3;
			    color: #004974;
			    text-decoration: none;
			}
			.btm{
	font-size:20px;     
	color:black; 
	display:inline-block;    
	width:100px;        
	height:30px;         
	line-height:30px;   
	border:1px solid black;
	text-align:center;
	font-size:20px;
	}  
	.btm:hover{
	
	}
	#tishi{
	text-align:center;  
	margin-top:30px;
	font-size:14px;
	}
	</style>
	
	

  </head>
  
  <body>
  <form  action="uploadServlet" method="post" enctype="multipart/form-data" >
     <table align="center"  border="0" cellpadding="0" cellspacing="0" class="biao">	
	       <tr>
					<td class="biaoti" colspan="2">
					    <p align="center">上传文件</p>
					</td>
	       </tr>
	       <tr>
				<td class="biaotou" width="50" height="50">标题：</td>
				<td class="neirong">
					<input  id="ttitle" name="ttitle" type="text" />
				</td>
	       </tr>
	       <tr>
				<td class="biaotou">类型：</td>
					<td class="neirong">
					      <select  name="types" id="types">	
			               <option value="txt">试题</option>
			               <option value="video">视频</option>
			              
					</select>
					</td>
	       </tr>
	        <tr>
				<td class="biaotou" width="50" height="50">上传人：</td>
				<td class="neirong">
					<input  id="tnames" name="tnames" type="text" />
				</td>
	       </tr>
	       <tr>
	       <td class="biaotou">内容：</td>
	       <td class="tneirong">
					    <input type="file" name="file" id="file" value="请选择">		
           </td>
           </tr>
    
      <tr>
	     <td class="neirong" colspan="2">
			 <input type="submit" value="提交"  class="btm" >	
					    
		</td>
	  </tr>	
	</table>
	
	</form>
  </body>
</html>
