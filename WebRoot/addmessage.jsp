<%@ page language="java" import="java.util.* ,com.dao.*"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
BaseDAO dao=new BaseDAO();
Map<String,Object> data=dao.getAll("*", "teacher");
List<Map<String,String>> tnames=(List<Map<String,String>>)data.get("records");
request.setAttribute("tnames", tnames); 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'message.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<!--  <link rel="stylesheet" type="text/css" href="login.css">-->
	<style>
	.biao{
	width:800px;
	font-size:16px;
	border:1px solid white;
	}
	.biaoti{
	font-size:23px;
	height:80px;
	}
	.biaotou{
	width:15%;
	height:50px;
	text-align:center;
	}	
	.neirong{
	width:80%;
	height:50px;
	padding:5px;
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
	.btm{
	font-size:20px;     
	color:#FCFCFC; 
	display:inline-block;    
	width:100px;        
	height:30px;         
	line-height:30px;   
	border:1px solid #FCFCFC;
	text-align:center;
	font-size:20px;
	background-color: #FCFCFC; 
	background:-webkit-linear-gradient(top,#3DA7E1,#72EBFE);
	}  
	.btm:hover{
	background:-webkit-linear-gradient(top, #72EBFE, #3DA7E1);
	}
	#tishi{
	text-align:center;  
	margin-top:30px;
	font-size:14px;
	}
	</style>
	
	<script src="jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="add.js"> </script>
	 </head>
  
  <body>
     <table align="center"  border="0" cellpadding="0" cellspacing="0" class="biao">	
	              <tr>
					<td class="biaoti" colspan="2">
					    <p align="center">我要留言</p>
					</td>
	              </tr>
	              <tr>
					<td class="biaotou" width="50" height="50">标题：</td>
					<td class="neirong">
					    <input  id="mtitle" name="mtitle" type="text" value=" ${r.mtitle}"/>
					</td>
	              </tr>
				  <tr>
					<td class="biaotou">老师：</td>
					<td class="neirong">
					      <select id="teacherid" name="teacherid">
					<c:forEach items="${tnames}" var="c">
			            <option value="${c.tname}" <c:if test="${c.teacherid==r.teacherid}">selected='selected'</c:if> >${c.tname}</option>
			        </c:forEach>
					</select>
	              
					</td>
	              </tr>
	              <tr>
	              <td class="biaotou">留言：</td>
					<td class="neirong">
					   <textarea rows="15" cols="63" id="text" name="text" type="textarea" value=" ${r.text} ">
					   
					   </textarea>
					</td></tr>
					<tr><td class="biaotou">留言人：</td>
					<td class="neirong">
					   <input  id="sname" name="sname" type="text" value=" ${r.sname}"/>
					   
					   </textarea>
					</td>
	              </tr>	
				  <tr>
					<td class="neirong" colspan="2" align="center">
					    <a href="javascript:void(0);" class="btm">保&nbsp;存</a>					    
					</td>
	              </tr>	
		</table>	
        <!-- 提示信息显示区 -->
        <div id="tishi"></div>	
  </body>
</html>
