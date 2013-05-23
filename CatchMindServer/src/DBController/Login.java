package DBController;

import java.sql.*;

import com.mysql.jdbc.PreparedStatement;

public class Login {

    static String jdbcUrl = "jdbc:mysql://localhost:3306/catchmind";// 사용하는 데이터베이스명을 포함한 url
    static String userId = "root";// 사용자계정
    static String userPass = "12345";// 사용자 패스워드
    
	static Connection conn = null;
	static PreparedStatement stmt = null;
    static ResultSet rs = null;
    
    static String NAME=null;
    static String ID=null;
    static String PASS=null;
    static String REGINUM=null;
    
    /* 로그인  */
    public static String Login(String id, String pass) throws SQLException{
    	try {
            Class.forName("com.mysql.jdbc.Driver");// 드라이버 로딩: DriverManager에 등록
	    	conn = DriverManager.getConnection(jdbcUrl, userId, userPass);// Connection 객체를 얻어냄
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
	    try {
	    	stmt = (PreparedStatement) conn.prepareStatement(
	    			"SELECT user_id, password FROM user WHERE user_id = ? and password =?");
	    	stmt.setString(1, id);
	    	stmt.setString(2, pass);
	    	rs = stmt.executeQuery();
	    	while(rs.next()){
	    		ID = rs.getString("user_id");
	    		PASS = rs.getString("password");
	    	}
	    	
	    } catch (SQLException e) {
	        System.out.println("SQLException: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	     	if(rs != null) try {rs.close();}catch(SQLException e){}
	       	if(stmt != null) try {stmt.close();}catch(SQLException e){}
	       	if(conn != null) try {conn.close();}catch(SQLException e){}
	    }
	    if((ID.equals(id)) && (PASS.equals(pass)))	return "true";
    	else										return "false";
    	
    }
    
    
    /* 회원가입 */
    public static String SignUp(String name, String id, String pass, String reginum) throws SQLException{
    	try {
            Class.forName("com.mysql.jdbc.Driver");// 드라이버 로딩: DriverManager에 등록
	    	conn = DriverManager.getConnection(jdbcUrl, userId, userPass);// Connection 객체를 얻어냄
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
        try {
        	stmt = (PreparedStatement) conn.prepareStatement(
	    			"INSERT INTO user(name,user_id,password,regi_num) VALUES(?, ?, ?, ?)");
	    	stmt.setString(1, name);
	    	stmt.setString(2, id);
	    	stmt.setString(3, pass);
	    	stmt.setString(4, reginum);
	    	int n = stmt.executeUpdate();
	    	if(n == 1)	return "true";
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        } finally {
        	if(rs != null) try {rs.close();}catch(SQLException e){}
        	if(stmt != null) try {stmt.close();}catch(SQLException e){}
        	if(conn != null) try {conn.close();}catch(SQLException e){}
        }
        return "";
    }
    
    /* 아이디 중복 체크 */
	public static String IDCheck(String id) throws SQLException {
		try {
            Class.forName("com.mysql.jdbc.Driver");// 드라이버 로딩: DriverManager에 등록
	    	conn = DriverManager.getConnection(jdbcUrl, userId, userPass);// Connection 객체를 얻어냄
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }

	    try {
	    	stmt = (PreparedStatement)conn.prepareStatement(
	    			"SELECT user_id FROM user WHERE user_id = ?");
	    	stmt.setString(1, id);
	    	rs = stmt.executeQuery();
	    	while(rs.next()){
	    		ID = rs.getString("user_id");
	    	}
	    	if(id.equals(ID))		return "false";
	    	
	    } catch (SQLException e) {
	        System.out.println("SQLException: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	     	if(rs != null) try {rs.close();}catch(SQLException e){}
	       	if(stmt != null) try {stmt.close();}catch(SQLException e){}
	       	if(conn != null) try {conn.close();}catch(SQLException e){}
	    }
	    //아이디 두개가 같으면 중복된 아이디가 있으므로 false를 반환하여 중복된 값이 있다는 것을 알려줌
		return "true";
	}

	/* 비밀번호 찾기 */
	public static String FindPass(String name,String id, String reginum) throws SQLException {
		// TODO Auto-generated method stub
		try {
            Class.forName("com.mysql.jdbc.Driver");// 드라이버 로딩: DriverManager에 등록
	    	conn = DriverManager.getConnection(jdbcUrl, userId, userPass);// Connection 객체를 얻어냄
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
	    try {
	    	
	    	stmt = (PreparedStatement)conn.prepareStatement(
	    			"SELECT password FROM user WHERE name = ? and user_id = ? and regi_num =?");
	    	stmt.setString(1, name);
	    	stmt.setString(2, id);
	    	stmt.setString(3, reginum);
	    	
	    	rs = stmt.executeQuery();
	    	while(rs.next()){
	    		PASS = rs.getString("password");
	    	}
	    } catch (SQLException e) {
	        System.out.println("SQLException: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	     	if(rs != null) try {rs.close();}catch(SQLException e){}
	       	if(stmt != null) try {stmt.close();}catch(SQLException e){}
	       	if(conn != null) try {conn.close();}catch(SQLException e){}
	    }
		if(!PASS.equals(null))	return PASS;
		else 					return null;
	}

	/* 아이디 찾기 */
	public static String FindID(String name, String reginum) throws SQLException {
		// TODO Auto-generated method stub
		try {
            Class.forName("com.mysql.jdbc.Driver");// 드라이버 로딩: DriverManager에 등록
	    	conn = DriverManager.getConnection(jdbcUrl, userId, userPass);// Connection 객체를 얻어냄
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
	    try {
	    	stmt = (PreparedStatement) conn.prepareStatement(
	    			"SELECT user_id FROM user WHERE name = ? and regi_num = ? ");
	    	stmt.setString(1, name);
	    	stmt.setString(2, reginum);
	    	
	    	rs = stmt.executeQuery();
	    	while(rs.next()){
	    		ID = rs.getString("user_id");
	    	}
	    	
	    } catch (SQLException e) {
	        System.out.println("SQLException: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	     	if(rs != null) try {rs.close();}catch(SQLException e){}
	       	if(stmt != null) try {stmt.close();}catch(SQLException e){}
	       	if(conn != null) try {conn.close();}catch(SQLException e){}
	    }
		if(!ID.equals(null))	return ID;
		else					return null;
	}
}
