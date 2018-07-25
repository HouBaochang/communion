$(function(){ 
	
		  
	$(".btn").bind("click",function(){
		   var url="addstudentServlet";
		   var sno=$("#sno").val(); 
		   var spsw=$("#spsw").val();
		   var sname=$("#sname").val();
		   alert(sname);
		   //验证通过后，用AJAX提交请求
		   $.ajax({
				 type:'GET',
				 url: url,
				 data: {
					sno:sno,
					spsw:spsw,
					sname:sname,
				 },
				 success: function(data) {
					  //data代表服务端返回的数据
					
					  if($.trim(data)=="1"){//添加成功
							//设置提示信息为绿色
						  alert("baba");
							$("#tishi").css("color","green");
							
								$("#tishi").html("添加学生成功");
							
							      
							//等待3秒后，重新用AJAX加载“添加新闻”页面
							setTimeout('ajaxLoadAddNewsPage()',3000);

					  }else{//添加失败
					    
						   $("#tishi").html("添加学生失败");
						 
					  }   
				 }
			});
		   function ajaxLoadAddStudentPage(){
				$.ajax({
					 type: 'post',
					 url: 'addstudent.jsp' ,
					 success: function(data) {
						  $("#buttom").html(data);
					 }
				 });	
		   }
});
	$(".btnt").bind("click",function(){
		   var url="addteacherServlet";
		   var tno=$("#tno").val(); 
		   var tpsw=$("#tpsw").val();
		   var tname=$("#tname").val();
		   alert(tname);
		   //验证通过后，用AJAX提交请求
		   $.ajax({
				 type:'GET',
				 url: url,
				 data: {
					tno:tno,
					tpsw:tpsw,
					tname:tname				
					},
				 success: function(data) {
					  //data代表服务端返回的数据
					
					  if($.trim(data)=="1"){//添加成功
							//设置提示信息为绿色
							$("#tishi").css("color","green");						
								$("#tishi").html("添加学生成功");
							
							      
							//等待3秒后，重新用AJAX加载“添加新闻”页面
							setTimeout('ajaxLoadAddNewsPage()',3000);

					  }else{//添加失败
					    
						   $("#tishi").html("添加学生失败");
						 
					  }   
				 }
			});
		   function ajaxLoadAddStudentPage(){
				$.ajax({
					 type: 'post',
					 url: 'addteacher.jsp' ,
					 success: function(data) {
						  $("#buttom").html(data);
					 }
				 });	
		   }
});
	$(function(){ 	
	$(".btm").bind("click",function(){
		   var url="addmessageServlet";
		   var mtitle=$("#mtitle").val(); 
		   var tname=$("#teacherid").val();
		   var text=$("#text").val();
		   var sname=$("#sname").val();
		   //验证通过后，用AJAX提交请求
		   $.ajax({
			  
				 type:'GET',
				 url: url,
				 data: {
					 
					mtitle:mtitle,
					tname:tname,
					sname:sname,
					text:text				
					},
				 success: function(data) {
					  //data代表服务端返回的数据
					  if($.trim(data)=="1"){//添加成功
							//设置提示信息为绿色
							$("#tishi").css("color","green");						
								$("#tishi").html("留言成功");     
							//等待3秒后，重新用AJAX加载“添加新闻”页面
							setTimeout('ajaxLoadAddNewsPage()',3000);

					  }else{//添加失败
					    
						   $("#tishi").html("留言失败");
						 
					  }   
				 }
			});
		   function ajaxLoadAddStudentPage(){
				$.ajax({
					 type: 'POST',
					 url: 'addmessage.jsp' ,
					 success: function(data) {
						  $("#buttom").html(data);
					 }
				 });	
		   }
});
});

$(".mbtm").bind("click",function(){
	var url="addanswerServlet";
	var answer=$("#answer").val();
	 $.ajax({
		  
		 type:'GET',
		 url: url,
		 data: {
			answer:answer,
			titleid:$("#titleid").val()
			},
		 success: function(data) {
			  //data代表服务端返回的数据
			  if($.trim(data)=="1"){//添加成功
					//设置提示信息为绿色
					$("#tishi").css("color","green");						
						$("#tishi").html("回复成功");
					
					      
					//等待3秒后，重新用AJAX加载“添加新闻”页面
					setTimeout('ajaxLoadAddNewsPage()',3000);

			  }else{//添加失败
			    
				   $("#tishi").html("留言失败");
				 
			  }   
		 }
	});
});
});
	 function ajaxLoadAddStudentPage(){
			$.ajax({
				 type: 'POST',
				 url: 'listmessage.jsp' ,
				 success: function(data) {
					  $("#buttom").html(data);
				 }
			 });	
	   }

