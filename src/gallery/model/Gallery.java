//게시물 한건을 담을 객체를 정의한다. 이와 같이 로직은 없으면서, 오직 데이터를 담아서 전달하는 목적의 객체를 설계분야에서는 dto,vo라 부른다.

package gallery.model;

public class Gallery {
	private int gallery_id;
	private String writer;
	private String title;
	private String content;
	private String regdate;
	private int hit;
	private String user_filename;
	
	
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
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getGallery_id() {
		return gallery_id;
	}
	public void setGallery_id(int gallery_id) {
		this.gallery_id = gallery_id;
	}
	public String getUser_filename() {
		return user_filename;
	}
	public void setUser_filename(String user_filename) {
		this.user_filename = user_filename;
	}
	
	

}
