//�Խù� �Ѱ��� ���� ��ü�� �����Ѵ�. �̿� ���� ������ �����鼭, ���� �����͸� ��Ƽ� �����ϴ� ������ ��ü�� ����о߿����� dto,vo�� �θ���.

package board.model;

public class Board {
	private int board_id;
	private String writer;
	private String title;
	private String content;
	private String regdate;
	private String user_Filename;
	private int hit;
	
	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getUser_Filename() {
		return user_Filename;
	}
	public void setUser_Filename(String user_Filename) {
		this.user_Filename = user_Filename;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	

}
