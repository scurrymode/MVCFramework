//일반적으로 DAO를 작성할때는 플랫폼 특성을 타면 안된다! 즉, 중립적이어야 한다. 그래야 웹이건 응용이건 사용이 가능하다!
package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pool.DBManager;

public class BoardDAO {
	DBManager manager=DBManager.getInstance();
	
	//레코드 한건 넣기!!
	public int insert(Board board){
		Connection con = null;
		PreparedStatement pstmt= null;
		int result=0;
		
		try {
			con = manager.getConnection();
			String sql = "insert into board(board_id, title, writer, content) values(seq_board.nextval, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.freeConnection(con, pstmt);
		}
		return result;
	}
	
	//목록 가져오기
	public List select(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql ="select * from board order by board_id desc"; //최신글 부터 보기
		ArrayList<Board> list = new ArrayList<Board>();
		
		try {
			con = manager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Board dto = new Board();
				dto.setBoard_id(rs.getInt("board_id"));
				dto.setContent(rs.getString("content"));
				dto.setHit(rs.getInt("hit"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.freeConnection(con, pstmt, rs);
		}
		return list;
	}
	
	//레코드 한건 가져오기~! 오버로딩도 사용해라~~!
	public Board select(int board_id){
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board dto = null;
		try {
			con = manager.getConnection();
			String sql = "select * from board where board_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				dto=new Board();
				dto.setBoard_id(rs.getInt("board_id"));
				dto.setWriter(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				dto.setHit(rs.getInt("hit"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setTitle(rs.getString("title"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.freeConnection(con, pstmt, rs);
		}
		return dto;		
	}
	
	public int delete(int board_id){
		Connection con =null;
		PreparedStatement pstmt = null;
		int result=0;
		try {
			con = manager.getConnection();
			String sql = "delete from board where board_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_id);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.freeConnection(con, pstmt);
		}
		return result;
	}
	
	public int update(Board dto){
		Connection con =null;
		PreparedStatement pstmt = null;
		int result=0;
		try {
			con = manager.getConnection();
			String sql = "update board set writer=?, title=?, content=? where board_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getBoard_id());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.freeConnection(con, pstmt);
		}
		return result;
	}
}
