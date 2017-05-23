/*
 * 비즈니스 로직 영역의 복잡한 세부업무는 컨트롤러가 알 필요도, 알수도 없다. 따라서 파일저장 및 db insert 작업을 처리해줄 비즈니스 로직 파트의 관리자 객체가 필요하다.
 * 그게 바로 service다.
 * */

package gallery.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class GalleryService {
	GalleryDAO galleryDAO = new GalleryDAO();
	ImageUploader uploader = new ImageUploader();
	
	public void upload(HttpServletRequest request){
		Gallery dto = uploader.makeDTO(request); //multipart/form-data이라서 request로 못읽고 여기서 읽어줘
		int seq = galleryDAO.insert(dto);
		uploader.save(seq);//파일저장
	}
	
	public List selectAll(){
		return galleryDAO.select();
	}
	
	public Gallery select(HttpServletRequest request){
		return galleryDAO.select(Integer.parseInt(request.getParameter("gallery_id")));
	}
}
