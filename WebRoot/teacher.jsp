<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
//进行登录页验证，防止没有登录直接进入此页面
     String tname=(String)session.getAttribute("tname");
     String tno=(String)session.getAttribute("tno");
    //username==null说明
    if(tno==null){
        out.println("<script>location.href='login.jsp';</script>");
        return;
    } 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>My JSP 'teacher.jsp' starting page</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
	<!-- 	<link rel="stylesheet" type="text/css" href="success.css">  -->
	<style type="text/css">
	#top{
          width:100%;
          height:130px;
          overflow:hidden;
       }
       #title{
           width:100%;
           height:80px;
           text-align:center;
           margin:0 auto; 
           
       }
       #status{
          width:500px;
          height:50px;
          float:right;
          margin-right:100px;
          font-size:20px;
          text-align:right;
       }
       a{
       color:black;
       }
        a:link,a:visited{
       text-decoration:none;
       }
        #left{
       width:15%;
       height:500px;
       margin-left:5%;
       float:left;
       clear:left;
       }
       #right{
       width:80%;
       height:800px;
       float:right;
       }
	</style>
	 <script src="jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
	$(function(){
	
	$(".xgm").bind("click",function(){
			$.ajax({
		
			    type: 'post',
			    url: 'teasure.jsp',
			    success:function(data){
			    $("#right").html(data);
			 }
			});
			});
			
	
	   $(".seemessage").bind("click",function(){
	   //回复留言
	      $.ajax({
	              type: 'post',
	              url: 'listmessageServlet',
	              success: function(data){
	              $("#right").html(data);
	              }
	      });//3
	   });//2
	   //历史留言
	   $(".htmessage").bind("click",function(){
// 	  	 alert("进来了");
			    //document.getElementById("my").style.display="none";  
                       //用AJAX发送GET请求获取"”页面
				       $.ajax({
						     type: 'GET',
						     url: 'TeacherRlistServlet' ,
						     success: function(data) {
						          //将“”页面的内容插入到页面的相应区域（id=neirong）
  									 $("#right").html(data);
							
						     },
						});
			   });   
	   
	    $(".addfile").bind("click",function(){
	    //上传文件
	      $.ajax({
	              type: 'post',
	              url: 'upload.jsp',
	              success: function(data){
	              $("#right").html(data);
	              }
	      });//3
	   });//2
	   
	     $(".video").bind("click",function(){ 
			   
// 			    alert("11"); 
					   var types="video";
                       //用AJAX发送GET请求获取"我的留言”页面
				       $.ajax({
						     type: 'GET',
						     url: 'ListspServlet',
						     data:{
						     	types:types
						     },
						     
						     success: function(data) {
						          //将“我的信息”页面的内容插入到页面的相应区域（id=neirong）
  									 $("#right").html(data);
						     } 
						});
			   }); 
			   
			    $(".text").bind("click",function(){ 
			   
// 			    alert("11"); 
					   var types="txt";
                       //用AJAX发送GET请求获取"我的留言”页面
				       $.ajax({
						     type: 'GET',
						     url: 'listwbsServlet',
						     data:{
						     	types:types
						     },
						     
						     success: function(data) {
						          //将“我的信息”页面的内容插入到页面的相应区域（id=neirong）
  									 $("#right").html(data);
						     } 
						});
			   }); 
	});//1
	</script>
  </head>
  
  <body>
   <body id="bc">
     <div id="top"> 
          <div id="title"  style="font-size:40px;">信商师生交流系统</div>
          <div id="status">
              <span style="color:black"><%=tname %></span><span>您好，欢迎登录</span>&nbsp&nbsp<a href="login.jsp">退出</a>
          </div>    
      </div>
      <div id="center">
          <div id="left" >
             <table class="t">
              <tr>
                <td><a href="javascript:void(0);" class="xgm" style="font-size:20px;">修改密码</a></td></tr>
              <td><a href="javascript:void(0);" class="seemessage" style="font-size:20px;" >回复留言</a></td></tr>
               <tr><td><a href="javascript:void(0);" class="htmessage" style="font-size:20px;" >历史留言</a></td></tr>
              <tr><td><a href="javascript:void(0);" class="addfile" style="font-size:20px;">文件上传</a></td></tr>
               <tr><td><a href="javascript:void(0);" class="video" style="font-size:20px;">教学视频</a></td></tr>
              <tr><td><a href="javascript:void(0);" class="text" style="font-size:20px;">教学文件</a></td></tr>
             </table>
          </div>
          <div id="right"></div>
      </div>
   
  </body>
  </body>
</html>
