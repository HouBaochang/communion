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
    
    <title>回复留言</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	.biao{
  margin-right:200px;
  border-collapse:collapse;}
 
  .biaotou3{
  width:300px;
  height:50px;
  text-align:center;
  border:1px solid black;
  }
 #neirong2{
   width:500px;
  height:50px;
  text-align:center;
  border:1px solid black;
 }
 input{
	width:90%;
	height:28px;
	color:#FCFCFC;
	border:1px solid black ;
	background:rgba(0,0,0,0);
	}
		.replylyAN{
	font-size:20px;     
	color:#FCFCFC; 
	display:inline-block;    
	width:100px;        
	height:30px;         
	line-height:30px;   
	border:1px solid black;
	text-align:center;
	 
	 font-size:20px;
	background-color: #FCFCFC; 
	background:-webkit-linear-gradient(top,#3DA7E1,#72EBFE);
	}  
	.replylyAN:hover{
	background:-webkit-linear-gradient(top, #72EBFE, #3DA7E1);
	}
	</style>
	<script src="jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
	$(function(){
		//添加“发出回复”的单击动作
		$(".replylyAN").bind("click",function(){  
		   //验证标题
		    var mtitle=$(".mtitle").html();
		   var answer=$(".answer").val();
		   var titleid=$(".titleid").html();
		 var tname=$(".tname").html();
		  var text=$(".texts").html();
			if(tname == "" || tname ==null){
				alert("获取教师用户名错误");
				alert(mtitle);
				alert(answer);
				alert(tname);
				alert(text);
				alert(titleid);
				return;
			}
		   if(answer.length==0){
				$("#tipinfo").html("请输入回复内容");
				return;
		   }else{
				$("#tipinfo").html("");
		   }
		   //验证通过后，用AJAX提交请求
		   $.ajax({
				 type: 'Get',
				 url: 'ReplystServlet',
				 data: {
				    mtitle:mtitle,
					answer:answer,
					tname:tname,
					text:text,
					titleid:titleid
				 },
				 success: function(data) {
				 alert(titleid);
					  //data代表服务端返回的数据
					  if($.trim(data)=="1"){//添加成功
							//设置提示信息为绿色
							$("#tipinfo").css("color","green");
							$("#tipinfo").html("回复成功");	      	
					  }else{//添加失败
						   $("#tipinfo").html("回复失败");
					  }   
				 }
			});
		});  
	}); 
	</script>
	<style type="text/css">
		.fabu{margin-left:500px;margin-top:40px;height:30px;width:100px;}
	</style>
  </head>
  
  <body>
    <!-- 提示信息显示区 -->
        <div id="tipinfo"></div>
	   <div>
	    <c:forEach items= "${requestScope.list}"  var="r">
	   <table  width="80%" border="0" cellpadding="0" cellspacing="0" class="biao" align="center"  style="text-align:center;">	
	            <tr>
					<td colspan="2" style="align:center; height:70px;">
					 <p style="font-size:25px;">回复留言<p>
					</td>
	          </tr>

	              <tr height="50px">
					<td class="biaotou3">标题：</td>
					<td  class="mtitle" id="neirong2">${r.mtitle}</td>
					<td style="display:none" class="titleid">${r.titleid}</td>
					<tr height="50px">
					<td class="biaotou3">老师：</td>
					<td  class="tname" id="neirong2">${r.tname}</td>
	              </tr>
	             
	              <tr height="60px">
					<td class="biaotou3">内容：</td>
					<td class="texts" id="neirong2">${r.text}</td>
	              </tr>
				  <tr height="60px">
				  <td class="biaotou3" >回复：</td>
					<td  colspan="2" id="neirong2">
					  <input type="text" style="width:500px;height:50px" class="answer" name="answer">${r.answer}</input>
					</td>
	              </tr>
	      
		
		
		<tr>
					<td colspan="2" id="neirong2">
					   <a href="javascript:void(0);" class=".btn"><span class="replylyAN">发出回复</span></a>
					</td>
	     </tr>
	     
		</c:forEach>
		</table>
		</div>
  </body>
</html>
