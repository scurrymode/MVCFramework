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
	
	//3단계: 알맞는 로직 객체에 일 시킨다.
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List list = service.selectAll();
		
		//4단계: 결과가 있으니 결과 저장
		request.setAttribute("list", list);
		
		return "/result/gallery/list";
	}

	public boolean isForward() {
		return true;
	}

}
