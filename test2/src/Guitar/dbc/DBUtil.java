package Guitar.dbc;
import java.sql.*;

import java.util.*;
public class DBUtil {
	private static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
 	private static final String DBURL = "jdbc:mysql://localhost:3306/guitar" ;
	private static final String DBUSER = "root" ;
	private static final String DBPASSWORD = "123456" ;
	private Connection conn = null ;
	//定义每页显示商品的数�?
	private static int span= 2 ;
	private static int getSpan(){
		return span ;
	}
	public static void setSpan(int i){
		span = i ;
	}
	static{
		try{
			Class.forName(DBDRIVER);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try{
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn ;
	}
	//ִ执行查询
	public ResultSet executeQuery(String sql){
		ResultSet rs = null ;
		try{
			Statement stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs ;
	}
	//ִ执行更新方法
	public int executeUpdate(String sql){
		int result = 0 ;
		try{
			Statement st = conn.createStatement();
			result = st.executeUpdate(sql);
			st.close() ;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

		
	//关闭数据库连�?
	public void closeAll(Connection conn, Statement stmt, ResultSet rs){
		try{
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	

	//根据sqlL语句获取查询到的内容
	public static List<String[]> getInfoArr(String sql){
		List<String[]> vtemp = new ArrayList<String[]>();
		try{
			DBUtil db = new DBUtil () ; 
			Connection conn = db.getConnection() ; //得到连接
			Statement st = conn.createStatement() ; //声明语句
			ResultSet rs =st.executeQuery(sql); //ִ执行语句得到结果�?
			ResultSetMetaData rsmt = rs.getMetaData() ; //得到结果集的元数�?
			int count = rsmt.getColumnCount() ; //得到结果集中的�?�列�?
			while(rs.next()){
				String[] str = new String[count] ;
				for(int i=0;i<count;i++){
					str[i] =rs.getString(i+1);
				}
				vtemp.add(str);
			   }
			db.closeAll(conn,st,rs);
		       }catch(Exception e){
		    	   e.printStackTrace();
			}
			return vtemp ;
		}
	//根据SQL语句获取信息
	public static List<String>getInfo(String sql){
		List<String> vclass = new ArrayList<String>();
		try{
			DBUtil db = new DBUtil() ;
			Connection conn = db.getConnection() ; //得到连接
			Statement st = conn.createStatement() ; //声明语句
			ResultSet rs =st.executeQuery(sql); //ִ执行语句得到结果�?
			while(rs.next()){
				String str = rs.getString(1);
				vclass.add(str);
			}
			db.closeAll(conn, st, rs);
		}catch(Exception e){
			e.printStackTrace();
		}
		return vclass ;
	}
	//根据SQL语句判断要查询的对象是否有效信息
    public static boolean isLegal(String sql){
    	boolean legal = false ;
    	DBUtil db = new DBUtil();
    	Connection conn = db.getConnection();
    	Statement stmt ;
    	ResultSet rs ;
    	try{
    		stmt = conn.createStatement();
    		rs = stmt.executeQuery(sql);
    		if(rs.next()){
    			legal = true ;
    		}
    		db.closeAll(conn, stmt, rs);
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	return legal ;
    }
}