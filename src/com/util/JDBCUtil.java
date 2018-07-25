package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;




public class JDBCUtil {
	
	public static final String dburl="jdbc:mysql://localhost:3306/communion?user=root&password=123&useUnicode=true&characterEncoding=utf8";
	
	//----------------------------以下是教师的操作------------------------------------
	//实现教师数据的添加
    public boolean addteacher(String gno,String teachername,String pwd){
    	boolean flag=false;
    	try {
    		
    		//1,加载JDBC驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2,建立连接
			String url=dburl; 
			Connection con= DriverManager.getConnection(url);
			
			//3,创建Statement
			Statement stmt = con.createStatement(); 
			//4,执行SQL语句
			String sql="insert into teacher set gno='"+gno+"',teachername='"+teachername+"',pwd='"+pwd+"'";
			int result=stmt.executeUpdate(sql);
			
			if(result>0){
				flag=true;
			}
			
			//5,关闭连接
			stmt.close();
			con.close();	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return flag;

    }
    
    
  //实现教师数据的修改
    public boolean updateteacher(String gno,String teachername,String pwd,String teacherid){
    	boolean flag=false;
    	try {
    		
    		//1,加载JDBC驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2,建立连接
			String url=dburl; 
			Connection con= DriverManager.getConnection(url);
			
			//3,创建Statement
			Statement stmt = con.createStatement(); 
			//4,执行SQL语句
			String sql="update teacher set gno='"+gno+"',teachername='"+teachername+"',pwd='"+pwd+"' where teacherid="+teacherid;
			int result=stmt.executeUpdate(sql);
			
			if(result>0){
				flag=true;
			}
			
			//5,关闭连接
			stmt.close();
			con.close();	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return flag;

    }
    
    
    //获取某一个教师的信息
    public Map<String,String> getteacher(String teacherid){
    	   	
    	Map<String,String> data=null;
    	try {
    		
    		//1,加载JDBC驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2,建立连接
			String url=dburl; 
			Connection con= DriverManager.getConnection(url);
			
			//3,创建Statement
			Statement stmt = con.createStatement(); 
			//4,执行SQL语句
			String sql="select * from teacher where teacherid="+teacherid;
			ResultSet rs=stmt.executeQuery(sql);
			
			//把查询到的数据转化成List<Map<String,String>>
			data=ZqDBUtil.getHashMap(rs).get(0);
			
			//5,关闭连接
			rs.close();
			stmt.close();
			con.close();	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return data;

    }

    //获取所有的教师信息
    public List<Map<String,String>> listteacher(){
    	   	
    	List<Map<String,String>> data=null;
    	try {
    		
    		//1,加载JDBC驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2,建立连接
			String url=dburl; 
			Connection con= DriverManager.getConnection(url);
			
			//3,创建Statement
			Statement stmt = con.createStatement(); 
			//4,执行SQL语句
			String sql="select * from teacher";
			ResultSet rs=stmt.executeQuery(sql);
			
			//把查询到的数据转化成List<Map<String,String>>
			data=ZqDBUtil.getHashMap(rs);
			
			//5,关闭连接
			rs.close();
			stmt.close();
			con.close();	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return data;

    }

    
  //实现教师数据的删除
    public boolean deleteteacher(String teacherid){
    	boolean flag=false;
    	try {
    		
    		//1,加载JDBC驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2,建立连接
			String url=dburl; 
			Connection con= DriverManager.getConnection(url);
			
			//3,创建Statement
			Statement stmt = con.createStatement(); 
			//4,执行SQL语句
			String sql="delete from teacher where teacherid="+teacherid;
			int result=stmt.executeUpdate(sql);
			
			if(result>0){
				flag=true;
			}
			
			//5,关闭连接
			stmt.close();
			con.close();	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return flag;

    }
    
    
  //----------------------------以下是学生的操作------------------------------------
    
  //实现学生数据的添加
    public boolean addstudent(String sno,String studentname,String pwd,String major){
    	boolean flag=false;
    	try {
    		
    		//1,加载JDBC驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2,建立连接
			String url=dburl; 
			Connection con= DriverManager.getConnection(url);
			
			//3,创建Statement
			Statement stmt = con.createStatement(); 
			//4,执行SQL语句
			String sql="insert into student set sno='"+sno+"',studentname='"+studentname+"',pwd='"+pwd+"',major='"+major+"'";
			int result=stmt.executeUpdate(sql);
			
			if(result>0){
				flag=true;
			}
			
			//5,关闭连接
			stmt.close();
			con.close();	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return flag;

    }
    
    
  //实现学生数据的修改
    public boolean updatestudent(String sno,String studentname,String pwd,String major,String studentid){
    	boolean flag=false;
    	try {
    		
    		//1,加载JDBC驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2,建立连接
			String url=dburl; 
			Connection con= DriverManager.getConnection(url);
			
			//3,创建Statement
			Statement stmt = con.createStatement(); 
			//4,执行SQL语句
			String sql="update student set sno='"+sno+"',studentname='"+studentname+"',pwd='"+pwd+"',major='"+major+"' where studentid="+studentid;
			int result=stmt.executeUpdate(sql);
			
			if(result>0){
				flag=true;
			}
			
			//5,关闭连接
			stmt.close();
			con.close();	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return flag;

    }
    
    
    //获取某一个学生的信息
    public Map<String,String> getstudent(String studentid){
    	   	
    	Map<String,String> data=null;
    	try {
    		
    		//1,加载JDBC驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2,建立连接
			String url=dburl; 
			Connection con= DriverManager.getConnection(url);
			
			//3,创建Statement
			Statement stmt = con.createStatement(); 
			//4,执行SQL语句
			String sql="select * from student where studentid="+studentid;
			ResultSet rs=stmt.executeQuery(sql);
			
			//把查询到的数据转化成List<Map<String,String>>
			data=ZqDBUtil.getHashMap(rs).get(0);
			
			//5,关闭连接
			rs.close();
			stmt.close();
			con.close();	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return data;

    }

    //获取所有的学生信息
    public List<Map<String,String>> liststudent(){
    	   	
    	List<Map<String,String>> data=null;
    	try {
    		
    		//1,加载JDBC驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2,建立连接
			String url=dburl; 
			Connection con= DriverManager.getConnection(url);
			
			//3,创建Statement
			Statement stmt = con.createStatement(); 
			//4,执行SQL语句
			String sql="select * from student";
			ResultSet rs=stmt.executeQuery(sql);
			
			//把查询到的数据转化成List<Map<String,String>>
			data=ZqDBUtil.getHashMap(rs);
			
			//5,关闭连接
			rs.close();
			stmt.close();
			con.close();	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return data;

    }

    
  //实现学生数据的删除
    public boolean deletestudent(String studentid){
    	boolean flag=false;
    	try {
    		
    		//1,加载JDBC驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2,建立连接
			String url=dburl; 
			Connection con= DriverManager.getConnection(url);
			
			//3,创建Statement
			Statement stmt = con.createStatement(); 
			//4,执行SQL语句
			String sql="delete from student where studentid="+studentid;
			int result=stmt.executeUpdate(sql);
			
			if(result>0){
				flag=true;
			}
			
			//5,关闭连接
			stmt.close();
			con.close();	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return flag;

    }
    
    
  //----------------------------以下是成绩的操作------------------------------------
  //实现成绩数据的添加
  public boolean addgrade(String course,String studentid,String teachername,String score){
  	boolean flag=false;
  	try {
  		
  		//1,加载JDBC驱动
  		Class.forName("com.mysql.jdbc.Driver");
  		
  		//2,建立连接
  		String url=dburl; 
  		Connection con= DriverManager.getConnection(url);
  		
  		String addtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
  		
  		//3,创建Statement
  		Statement stmt = con.createStatement(); 
  		//4,执行SQL语句
  		String sql="insert into grade set course='"+course+"',studentid='"+studentid+"',teachername='"+teachername+"',score='"+score+"',addtime='"+addtime+"'";
  		int result=stmt.executeUpdate(sql);
  		
  		if(result>0){
  			flag=true;
  		}
  		
  		//5,关闭连接
  		stmt.close();
  		con.close();	
  		
  		
  	} catch (Exception e) {
  		e.printStackTrace();
  	}
  	
  	
  	return flag;

  }


  


  //获取某一个成绩的信息
  public Map<String,String> getgrade(String gradeid){
  	   	
  	Map<String,String> data=null;
  	try {
  		
  		//1,加载JDBC驱动
  		Class.forName("com.mysql.jdbc.Driver");
  		
  		//2,建立连接
  		String url=dburl; 
  		Connection con= DriverManager.getConnection(url);
  		
  		//3,创建Statement
  		Statement stmt = con.createStatement(); 
  		//4,执行SQL语句
  		String sql="select * from grade where gradeid="+gradeid;
  		ResultSet rs=stmt.executeQuery(sql);
  		
  		//把查询到的数据转化成List<Map<String,String>>
  		data=ZqDBUtil.getHashMap(rs).get(0);
  		
  		//5,关闭连接
  		rs.close();
  		stmt.close();
  		con.close();	
  		
  		
  	} catch (Exception e) {
  		e.printStackTrace();
  	}
  	
  	
  	return data;

  }

  //通用的查询列表
  public List<Map<String,String>> commonlist(String sql){
  	   	
  	List<Map<String,String>> data=null;
  	try {
  		
  		//1,加载JDBC驱动
  		Class.forName("com.mysql.jdbc.Driver");
  		
  		//2,建立连接
  		String url=dburl; 
  		Connection con= DriverManager.getConnection(url);
  		
  		//3,创建Statement
  		Statement stmt = con.createStatement(); 
  		//4,执行SQL语句
  		ResultSet rs=stmt.executeQuery(sql);
  		
  		//把查询到的数据转化成List<Map<String,String>>
  		data=ZqDBUtil.getHashMap(rs);
  		
  		//5,关闭连接
  		rs.close();
  		stmt.close();
  		con.close();	
  		
  		
  	} catch (Exception e) {
  		e.printStackTrace();
  	}
  	
  	
  	return data;

  }


  //实现成绩数据的删除
  public boolean deletegrade(String gradeid){
  	boolean flag=false;
  	try {
  		
  		//1,加载JDBC驱动
  		Class.forName("com.mysql.jdbc.Driver");
  		
  		//2,建立连接
  		String url=dburl; 
  		Connection con= DriverManager.getConnection(url);
  		
  		//3,创建Statement
  		Statement stmt = con.createStatement(); 
  		//4,执行SQL语句
  		String sql="delete from grade where gradeid="+gradeid;
  		int result=stmt.executeUpdate(sql);
  		
  		if(result>0){
  			flag=true;
  		}
  		
  		//5,关闭连接
  		stmt.close();
  		con.close();	
  		
  		
  	} catch (Exception e) {
  		e.printStackTrace();
  	}
  	
  	
  	return flag;

  }
  
     //----------------------------以下是登录的操作------------------------------------
	  //验证教师信息是否正确
	  public Map<String,String> validateTeacher(String username,String password){
	  	   	
		  Map<String,String> record=null;
	  	try {
	  		
	  		//1,加载JDBC驱动
				Class.forName("com.mysql.jdbc.Driver");
				
				//2,建立连接
				String url=dburl; 
				Connection con= DriverManager.getConnection(url);
				
				//3,创建Statement
				Statement stmt = con.createStatement(); 
				//4,执行SQL语句
				String sql="select * from teacher where gno='"+username+"' and pwd='"+password+"'";
				ResultSet rs=stmt.executeQuery(sql);
				
				//把查询到的数据转化成List<Map<String,String>>
				List<Map<String,String>> data=ZqDBUtil.getHashMap(rs);
				if(data.size()>0){
					record=data.get(0);
				}
				
				//5,关闭连接
				rs.close();
				stmt.close();
				con.close();	
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return record;
	
	  }
	  
	  //验证学生信息是否正确
	  public Map<String,String> validateStudent(String username,String password){
	  	   	
		  Map<String,String> record=null;
	  	try {
	  		
	  		//1,加载JDBC驱动
				Class.forName("com.mysql.jdbc.Driver");
				
				//2,建立连接
				String url=dburl; 
				Connection con= DriverManager.getConnection(url);
				
				//3,创建Statement
				Statement stmt = con.createStatement(); 
				//4,执行SQL语句
				String sql="select * from student where sno='"+username+"' and pwd='"+password+"'";
				ResultSet rs=stmt.executeQuery(sql);
				
				//把查询到的数据转化成List<Map<String,String>>
				List<Map<String,String>> data=ZqDBUtil.getHashMap(rs);
				if(data.size()>0){
					record=data.get(0);
				}
				
				//5,关闭连接
				rs.close();
				stmt.close();
				con.close();	
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return record;
	
	  }
	  
	//验证教务人员信息是否正确
	  public Map<String,String> validateAdmin(String username,String password){
	  	   	
		  Map<String,String> record=null;
	  	try {
	  		
	  		//1,加载JDBC驱动
				Class.forName("com.mysql.jdbc.Driver");
				
				//2,建立连接
				String url=dburl; 
				Connection con= DriverManager.getConnection(url);
				
				//3,创建Statement
				Statement stmt = con.createStatement(); 
				//4,执行SQL语句
				String sql="select * from admin where username='"+username+"' and pwd='"+password+"'";
				ResultSet rs=stmt.executeQuery(sql);
				
				//把查询到的数据转化成List<Map<String,String>>
				List<Map<String,String>> data=ZqDBUtil.getHashMap(rs);
				if(data.size()>0){
					record=data.get(0);
				}
				
				//5,关闭连接
				rs.close();
				stmt.close();
				con.close();	
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return record;
	
	  }
	  
	//通用的添加，修改，删除  insert,update,delete
	  public boolean commonupdate(String sql){
	  	   	
	  	boolean flag=false;
	  	try {
	  		
	  		//1,加载JDBC驱动
	  		Class.forName("com.mysql.jdbc.Driver");
	  		
	  		//2,建立连接
	  		String url=dburl; 
	  		Connection con= DriverManager.getConnection(url);
	  		
	  		//3,创建Statement
	  		Statement stmt = con.createStatement(); 
	  		//4,执行SQL语句
	  		int result=stmt.executeUpdate(sql);
	  		
	  		if(result>0){
	  			flag=true;
	  		}
	  		
	  		//5,关闭连接
	  		stmt.close();
	  		con.close();	
	  		
	  		
	  	} catch (Exception e) {
	  		e.printStackTrace();//在命令行打印异常信息在程序中出错的位置
	  	}
	  	
	  	
	  	return flag;

	  }
	
	  
//	  private static String driver;
//			private static String url;
//			private static String name;
//			private static String password;
//			private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();// 事务专用
//		// 获取数据库连接
//			public static Connection getConnection() throws SQLException {
//				/*
//				 * 如果有事务，且tl中已经有连接，则返回当前事务tl的conn 如果有事务，tl中没有连接，则生成一个新的连接返回
//				 * 如果没有事务，生成一个新的连接返回。
//				 */
//				Connection conn = tl.get();// 获取当前线程的事务连接
//				if (conn != null)
//					return conn;
//				return DriverManager.getConnection(url, name, password);
//			}
//			private static void fillStatement(PreparedStatement pre, Object... params)
//					throws SQLException {
//				if (params != null) {
//					for (int i = 0; i < params.length; i++) {
//						pre.setObject(i + 1, params[i]);
//					}
//				}
//			}
//			
//			// 释放连接
//			public static void release(Connection conn, Statement stmt, ResultSet rs) {
//				try {
//					if (rs != null) {
//						rs.close();
//					}
//				} catch (SQLException e) {
//					throw new RuntimeException(e.getMessage(), e);
//				} finally {
//					try {
//						if (stmt != null) {
//							stmt.close();
//						}
//					} catch (SQLException e) {
//						throw new RuntimeException(e.getMessage(), e);
//					} finally {
//						// 如果是事务，则不关闭数据库连接（在事务的提交或回滚中关闭）
//						Connection transConn = tl.get();// 有事务
//						if (transConn == conn) {// 要关闭的是事务的连接
//							return;
//						}
//						if (conn != null) {
//							try {
//								conn.close();
//							} catch (SQLException e) {
//								throw new RuntimeException(e.getMessage(), e);
//							}
//						}
//					}
//				}
//
//			}
//
//		// 添加操作，需要返回自增的主键
//			public static Object insert(String sql, Object... params) {
//				Connection conn = null;
//				PreparedStatement pre = null;
//				ResultSet rs = null;
//				try {
//					// 获取数据库连接
//					conn = getConnection();
//					// 获取PreparedStatment对象
//					pre = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//					// 设置sql参数值
//					fillStatement(pre, params);
//					// 执行sql语句
//					pre.executeUpdate();
//					// 获取主键
//					rs = pre.getGeneratedKeys();
//					Object key = null;
//					if (rs.next()) {
//						key = rs.getObject(1);
//					}
//					return key;
//				} catch (SQLException e) {
//					throw new RuntimeException(e.getMessage(), e);
//				} finally {
//					release(conn, pre, null);
//				}
//			}
//
//    
}