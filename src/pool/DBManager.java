//Ŀ�ؼ� ��ü�� �ʿ�� �ϴ� �ܺ� ��ü�鿡�� Connection�� �������ִ� �Ŵ���..
//javaSE���� ����ߴ�, �Ŵ����� ������: ���� ����� �Ŵ����� JNDI�� ���� Ŀ�ؼ��� ���� ��!
//������: �̱������� ����

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
	InitialContext context;//�˻� ��ü
	DataSource ds; //Ŀ�ؼ��� ��� ���� ��ü
	
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
	
	//Ŀ�ؼ� ��ȯ 
	public Connection getConnection(){
		Connection con = null;
		try {
			con=ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//Ŀ�ؼ� �ݳ�
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
	
	//Ŀ�ؼ� �ݳ� select �� �����ε�
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
