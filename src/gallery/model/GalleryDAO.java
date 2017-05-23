//�Ϲ������� DAO�� �ۼ��Ҷ��� �÷��� Ư���� Ÿ�� �ȵȴ�! ��, �߸����̾�� �Ѵ�. �׷��� ���̰� �����̰� ����� �����ϴ�!
package gallery.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pool.DBManager;

public class GalleryDAO {
	DBManager manager=DBManager.getInstance();
	
	//���ڵ� �Ѱ� �ֱ�!!
	public int insert(Gallery gallery){
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs =null;
		int seq=0;
		
		try {
			con = manager.getConnection();
			String sql = "insert into gallery(gallery_id, title, writer, content, user_filename) values(seq_gallery.nextval, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gallery.getTitle());
			pstmt.setString(2, gallery.getWriter());
			pstmt.setString(3, gallery.getContent());
			pstmt.setString(4, gallery.getUser_filename());
			int result = pstmt.executeUpdate();
			
			
			//������ ���
			sql = "select seq_gallery.currval as seq from dual";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(result!=0){
				if(rs.next()){
					seq = rs.getInt("seq");
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.freeConnection(con, pstmt, rs);
		}
		return seq;
	}
	
	//��� ��������
	public List select(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql ="select * from gallery order by gallery_id desc"; //�ֽű� ���� ����
		ArrayList<Gallery> list = new ArrayList<Gallery>();
		
		try {
			con = manager.getConnection();
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Gallery dto = new Gallery();
				dto.setGallery_id(rs.getInt("gallery_id"));
				dto.setContent(rs.getString("content"));
				dto.setHit(rs.getInt("hit"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setUser_filename(rs.getString("user_filename"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.freeConnection(con, pstmt, rs);
		}
		return list;
	}
	
	//���ڵ� �Ѱ� ��������~! �����ε��� ����ض�~~!
	public Gallery select(int gallery_id){
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Gallery dto = null;
		try {
			con = manager.getConnection();
			String sql = "select * from gallery where gallery_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, gallery_id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				dto=new Gallery();
				dto.setGallery_id(rs.getInt("gallery_id"));
				dto.setWriter(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				dto.setHit(rs.getInt("hit"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setTitle(rs.getString("title"));
				dto.setUser_filename(rs.getString("user_filename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.freeConnection(con, pstmt, rs);
		}
		return dto;		
	}
	
	public int delete(int gallery_id){
		Connection con =null;
		PreparedStatement pstmt = null;
		int result=0;
		try {
			con = manager.getConnection();
			String sql = "delete from gallery where gallery_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, gallery_id);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.freeConnection(con, pstmt);
		}
		return result;
	}
	
	public int update(Gallery dto){
		Connection con =null;
		PreparedStatement pstmt = null;
		int result=0;
		try {
			con = manager.getConnection();
			String sql = "update gallery set writer=?, title=?, content=? where gallery_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getGallery_id());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			manager.freeConnection(con, pstmt);
		}
		return result;
	}
}
