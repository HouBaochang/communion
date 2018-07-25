package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Utils.JDBCUtils;
import com.util.JDBCUtil;
import com.util.ZqDBUtil;


public class BaseDAO {

	public static final String url="jdbc:mysql://127.0.0.1:3306/communion?user=root&password=123&useUnicode=true&characterEncoding=utf8";
	//查询单条记录
	public Map<String,String> getOneByWhere(String field,String table,String where){
		Map<String,String> record=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url);
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select "+field+" from "+table+" where 1=1"+where);
            List<Map<String,String>> data=ZqDBUtil.getHashMap(rs);
			if(data.size()>0){
				record=data.get(0);
			}
			con.close();
			rs.close();
			stmt.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return record;
	}
	//添加学生
	public boolean addOne(String sn, String spsw, String sname){
		    boolean flag=false;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con= DriverManager.getConnection(url);
				Statement stmt = con.createStatement();
				String sql="insert into student(sno,spsw,sname)values("+sn+",'"+spsw+"',"+"'"+sname+"'"+")";
				int count=stmt.executeUpdate(sql);
	            if(count>0){
	            	flag=true;
	            }
				con.close();
				stmt.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
	 }
	//添加学习资料
		public boolean addZiliao(String wjname, String surl, String tnames, String ttitle, String types){
			    boolean flag=false;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con= DriverManager.getConnection(url);
					Statement stmt = con.createStatement();
					String sql="insert into test(wjname, surl, tnames, ttitle,types)values('"+wjname+"','"+surl+"','"+tnames+"','"+ttitle+"','"+types+"')";
					int count=stmt.executeUpdate(sql);
		            if(count>0){
		            	flag=true;
		            }
					con.close();
					stmt.close();	
				} catch (Exception e) {
					e.printStackTrace();
				}
				return flag;
		 }
		//添加老师
	public boolean addteacher(String tn, String tpsw, String tname){
	    boolean flag=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url);
			Statement stmt = con.createStatement();
			String sql="insert into teacher(tno,tpsw,tname)values("+tn+",'"+tpsw+"',"+"'"+tname+"'"+")";
			int count=stmt.executeUpdate(sql);
            if(count>0){
            	flag=true;
            }
			con.close();
			stmt.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
 }
	//添加留言
	public boolean addmessage(String mtitle,String tname,String text,String sname){
	    boolean flag=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url);
			Statement stmt = con.createStatement();
			String sql="insert into message(mtitle,tname,text,sname)values('"+mtitle+"','"+tname+"','"+text+"','"+sname+"')";
			int count=stmt.executeUpdate(sql);
            if(count>0){
            	flag=true;
            }
			con.close();
			stmt.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
 }
	
	/*public boolean addanswer(String answer,String titleid){
	    boolean flag=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url);
			Statement stmt = con.createStatement();
			String sql="update message set answer='"+answer+"' where titleid="+titleid;
			int count=stmt.executeUpdate(sql);
            if(count>0){
            	flag=true;
            }
			con.close();
			stmt.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
 }*/
	//查询多条记录
	public Map<String,Object> getAll(String field,String table,String where,String orderby,int startIndex,int pageSize){
		
		Map<String,Object> data=new HashMap<String,Object>();
		
		List<Map<String,String>> records=new ArrayList<Map<String,String>>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url);
			Statement stmt = con.createStatement();
			String sql="select "+field+" from "+table+"where 1=1"+where+" order by "+orderby+" limit "+startIndex+","+pageSize;
			ResultSet rs=stmt.executeQuery(sql);
            records=ZqDBUtil.getHashMap(rs);
            
            System.out.println("sql:"+sql);
            
            //String sqlcount="select count(*) totalCount from "+table+" where 1=1"+where;
           // ResultSet rs2=stmt.executeQuery(sqlcount);
           // rs2.next();
           // int totalCount=rs2.getInt("totalCount");
           // System.out.println("sqlcount:"+sqlcount);
            //记录列表
            data.put("records", records);
            //记录总数
            //data.put("totalCount", totalCount);
            
            
			con.close();
			rs.close();
			stmt.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	
	
	
	//查询多条记录
	public Map<String,Object> getAlls(String field,String table){
		
		Map<String,Object> data=new HashMap<String,Object>();
		
		List<Map<String,String>> recordss=new ArrayList<Map<String,String>>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection(url);
			Statement stmt = con.createStatement();
			String sql="select "+field+" from "+table+"";
			ResultSet rs=stmt.executeQuery(sql);
            recordss=ZqDBUtil.getHashMap(rs);
            
            System.out.println("sql:"+sql);
            
            //String sqlcount="select count(*) totalCount from "+table+" where 1=1"+where;
           // ResultSet rs2=stmt.executeQuery(sqlcount);
           // rs2.next();
           // int totalCount=rs2.getInt("totalCount");
           // System.out.println("sqlcount:"+sqlcount);
            //记录列表
            data.put("recordss", recordss);
            //记录总数
            //data.put("totalCount", totalCount);
            
            
			con.close();
			rs.close();
			stmt.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	//修改记录
	public boolean updateOne(String table,String fields){
		    boolean flag=false;
		    try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con= DriverManager.getConnection(url);
				Statement stmt = con.createStatement();
				int count=stmt.executeUpdate("update "+table+" set "+fields);
	            if(count>0){
	            	flag=true;
	            }
				con.close();
				stmt.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;}
	
	//删除记录
	public boolean deleteOne(String table,String id){
		    boolean flag=false;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con= DriverManager.getConnection(url);
				Statement stmt = con.createStatement();
				int count=stmt.executeUpdate("delete from "+table+" where "+table+"id="+id);
	            if(count>0){
	            	flag=true;
	            }
				con.close();
				stmt.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
	 }
	
	////查询所有视频或试题
	public List<Map<String,Object>> getSp(String types){
		List<Map<String, Object>> list=null;	
		String sql="select * from test where types=?";
		Object[] params={types};
		list=JDBCUtils.select(sql, params);
		System.out.println(list);
		return list;
	}
	
	//根据信息id查询留言
     public List<Map<String, Object>> getLY(String titleid) {
		List<Map<String, Object>> list=null;	
		String sql="select * from message where titleid=?";
		Object[] params={titleid};
		list=JDBCUtils.select(sql, params);
		return list;
		}
     
   //回复留言
   		public boolean replyly(String mtitle, String tname, String text, String answer, String titleid) {
   			// TODO Auto-generated method stub
//   			String sql = "update  liuyan set tno='"+tno+"',replier='"+replier+"',rpcontent = '"+rpcontent+"' where lyid = '"+lyid+"' values(?,?,?,?) ";
   			String sql = "update message set mtitle=?,tname=?,text=?,answer=?where titleid=?"; 
   			Object[] params={mtitle,tname,text,answer,titleid};
   			int count=JDBCUtils.update(sql, params);
   			if(count==0){
   				return false; 
   			}
   			return true;
   		}
   	//根据教师id查询信息老师回复过的留言
   		public List<Map<String, Object>> getTeacherRlisr(String tname) {
   				List<Map<String, Object>> list=null;	
   				String sql="select * from message where tname=?";
   				Object[] params={tname};
   				list=JDBCUtils.select(sql, params);
   				return list;
   				}
   		
   	//根据教师id查询信息老师回复过的留言
   		public List<Map<String, Object>> getTeacherRlisrs(String sname) {
   				List<Map<String, Object>> list=null;	
   				String sql="select * from message where sname=?";
   				Object[] params={sname};
   				list=JDBCUtils.select(sql, params);
   				return list;
   				}
}
