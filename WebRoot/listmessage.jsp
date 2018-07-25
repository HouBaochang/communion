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
   	$(function(){ 
		
		$(".reply").bind("click",function(){ 
// 		  var lyid=$(".lyid").html();
		 	var titleid=$(this).attr("url");
			var answer=$(this).attr("re");
			if(answer !="" && answer != null){
					alert("该留言已被回复"); 
					return;
			 }else{	 
			  $.ajax({
					 type: 'POST',
					 url: 'ReplyServlet',
					 data: {titleid:titleid},
					 success: function(data) { 
						 $("#right").html(data);
					 }
				});
			}
		});  
		
	});
			/*function answer(){
		myWindow=window.open('manswer.jsp','','width=800,height=400,top=50,left=300');
        myWindow.document.write(manswer.jsp);
        myWindow.focus();
			}*/
       </script>
  </head>
  
  <body>
   <table align="center" width="900" border="0" cellpadding="0" cellspacing="0" class="biao" style="text-align:center;">	
	              <tr>
					<td class="biaoti" colspan="3" style="text-align:center;">
					    <p style="font-size:25px;  height:60px;">回复留言</p>
					</td>
	              </tr>
	              <tr>

					 <td class="biaotou2">标题</td>
					<td class="biaotou2">老师</td>
					<td class="biaotou1">内容</td>
					<td class="biaotou2">操作</td>
	              </tr>
	              <c:forEach items="${records}" var="r">
				  <tr>
				   <td class="nieorng2" style="display:none"><a class="titleid">${r.titleid}</a></td>
					<td class="neirong2">${r.mtitle}</td>
					<td class="neirong2">${r.tname}</td>
					<td class="neirong1">${r.text}</td>
					<td class="neiorng2" style="display:none"><a class="answer">${r.answer}</a></td>
					<td class="neirong2">
		<a class="reply" style="cursor:hand"  href="javascript:void(0)" url="${r.titleid}" re="${r.answer}">
		回复留言</a></td>
	              </tr>
	              </c:forEach>
	 </table>   
	 <div align="center" style="font-size:14px">
		  
		  
		  共找到${totalCount}条记录，当前第${curpage}页，共有${totalPage}页，每页${pageSize}条记录
		  
		  &nbsp;&nbsp;
		  <c:if test="${curpage=='1'}">
		     首页
		  </c:if>
		  <c:if test="${curpage!='1'}">
		     <a href="javascript:toPage2('1','listNewsServlet?a=123')">首页</a>
		  </c:if>   
		  <c:if test="${curpage=='1'}">
		     上一页 
		  </c:if>
		  <c:if test="${curpage!='1'}">
		     <a href="javascript:toPage2('${curpage-1}','listNewsServlet?a=123')">上一页</a> 
		  </c:if> 
		  <c:if test="${curpage==totalPage}">
		     下一页 
		  </c:if>
		  <c:if test="${curpage!=totalPage}">
		     <a href="javascript:toPage2('${curpage+1}','listNewsServlet?a=123')">下一页</a> 
		  </c:if>
		     
		  <c:if test="${curpage==totalPage}">
		     尾页
		  </c:if>
		  <c:if test="${curpage!=totalPage}">
		     <a href="javascript:toPage2('${totalPage}','listNewsServlet?a=123')">尾页</a>
		  </c:if>
		  </div>          
  </body>
</html>
