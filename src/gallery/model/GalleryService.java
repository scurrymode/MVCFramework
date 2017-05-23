/*
 * ����Ͻ� ���� ������ ������ ���ξ����� ��Ʈ�ѷ��� �� �ʿ䵵, �˼��� ����. ���� �������� �� db insert �۾��� ó������ ����Ͻ� ���� ��Ʈ�� ������ ��ü�� �ʿ��ϴ�.
 * �װ� �ٷ� service��.
 * */

package gallery.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class GalleryService {
	GalleryDAO galleryDAO = new GalleryDAO();
	ImageUploader uploader = new ImageUploader();
	
	public void upload(HttpServletRequest request){
		Gallery dto = uploader.makeDTO(request); //multipart/form-data�̶� request�� ���а� ���⼭ �о���
		int seq = galleryDAO.insert(dto);
		uploader.save(seq);//��������
	}
	
	public List selectAll(){
		return galleryDAO.select();
	}
	
	public Gallery select(HttpServletRequest request){
		return galleryDAO.select(Integer.parseInt(request.getParameter("gallery_id")));
	}
}
