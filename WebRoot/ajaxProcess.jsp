<%@ page language="java" import="java.util.*,com.dao.*" pageEncoding="utf-8"%>
<%
    //1， 转码
    request.setCharacterEncoding("utf-8");
    //2,接收数据
    String ano=request.getParameter("username");
    String apsw=request.getParameter("password");
    String sno=request.getParameter("username");
    String spsw=request.getParameter("password");
    String tno=request.getParameter("username");
    String tpsw=request.getParameter("password");   
    //3,登录判断逻辑
    BaseDAO dao=new BaseDAO();
    Map<String,String> record=null;
     if(dao.getOneByWhere("*","admin"," and ano='"+ano+"' and apsw='"+apsw+"'")!=null){
         //将用户名数据存入session，以便作登录保护用
         record=dao.getOneByWhere("*","admin"," and ano='"+ano+"' and apsw='"+apsw+"'");
         session.setAttribute("ano",record.get("ano"));
         session.setAttribute("apsw",record.get("apsw"));
		 	session.setAttribute("aname",record.get("aname"));
		 	session.setAttribute("adminid",record.get("adminid"));
		 	//session.setAttribute("apsw",record.get("apsw"));
               
         //返回登录成功数据（1代表0成功）
         out.println("1");
    } else{   
    if(dao.getOneByWhere("*","student"," and sno='"+sno+"' and spsw='"+spsw+"'")!=null){
    record=dao.getOneByWhere("*","student"," and sno='"+sno+"' and spsw='"+spsw+"'");
	 session.setAttribute("sname",record.get("sname"));
     session.setAttribute("sno",record.get("sno")); 
     session.setAttribute("spsw",record.get("spsw")); 
     session.setAttribute("studentid",record.get("studentid")); 
     out.println("2"); 
     } else{
      
     if(dao.getOneByWhere("*","teacher"," and tno='"+tno+"' and tpsw='"+tpsw+"'")!=null){
      record=dao.getOneByWhere("*","teacher"," and tno='"+tno+"' and tpsw='"+tpsw+"'");
	 session.setAttribute("tno",record.get("tno"));
	 session.setAttribute("tpsw",record.get("tpsw"));
	 session.setAttribute("tname",record.get("tname"));
	 session.setAttribute("teacherid",record.get("teacherid")); 
     out.println("3"); 
     }else{
    
     out.println("0");
     }
     }
   }
    return;
 %>