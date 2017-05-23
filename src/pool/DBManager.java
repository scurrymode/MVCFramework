//커넥션 객체를 필요로 하는 외부 객체들에게 Connection을 제공해주는 매니저..
//javaSE에서 사용했던, 매니저와 차이점: 지금 사용할 매니저는 JNDI로 부터 커넥션을 얻어올 것!
//공통점: 싱글톤으로 개발

package pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {
	private static DBManager instance;
	InitialContext context;//검색 객체
	DataSource ds; //커넥션을 얻기 위한 객체
	
	private DBManager(){
		try {
			context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/myoracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static DBManager getInstance() {
		if(instance==null){
			instance = new DBManager();
		}
		return instance;
	}
	
	//커넥션 반환 
	public Connection getConnection(){
		Connection con = null;
		try {
			con=ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//커넥션 반납
	public void freeConnection(Connection con, PreparedStatement pstmt){
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//커넥션 반납 select 용 오버로딩
		public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs){
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
}
