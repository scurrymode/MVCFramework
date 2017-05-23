package mvc.controller.gallery;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gallery.model.GalleryService;
import mvc.controller.Controller;

public class ListController implements Controller{
	GalleryService service = new GalleryService();
	
	//3�ܰ�: �˸´� ���� ��ü�� �� ��Ų��.
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List list = service.selectAll();
		
		//4�ܰ�: ����� ������ ��� ����
		request.setAttribute("list", list);
		
		return "/result/gallery/list";
	}

	public boolean isForward() {
		return true;
	}

}
