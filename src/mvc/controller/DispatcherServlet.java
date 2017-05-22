/*
 * �� Ŭ������ �����ø����̼��� ��� ��û�� 1�������� �޴� ��Ʈ�ѷ��̹Ƿ�, ������ ��û�� �������� �������� �����ؾ� �Ѵ�.
 * */

package mvc.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class DispatcherServlet extends HttpServlet{
	FileInputStream fis;
	InputStreamReader is;
	BufferedReader buffr;
	JSONObject jsonObject;
	
	
	public void init(ServletConfig config) throws ServletException {
		//jsp ������ application ���尴ü�� �ڷ���!
		ServletContext context = config.getServletContext();
		String realPath=context.getRealPath(config.getInitParameter("configLocation"));
		System.out.println(realPath);
		
		try {
			fis = new FileInputStream(realPath);
			is = new InputStreamReader(fis);
			buffr = new BufferedReader(is);
			String str = null;
			StringBuffer sb = new StringBuffer();
			while(true){
				str = buffr.readLine();
				if(str==null)break;
				sb.append(str);
			}
			JSONParser parser = new JSONParser();
			jsonObject = (JSONObject)parser.parse(sb.toString());	
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	//POST, GET�� � ����� ��û�� ������ ó���� �� �־�� �ϹǷ�, ���� ��û�� ó���ϴ� �޼��带 ������ �����س���!!
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	public void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//1�ܰ�: ��û�� �޴´�.
		//System.out.println("��û�� ���Գ׿�");
		request.setCharacterEncoding("utf-8");
		//jsp������ ������ ���ÿ����� ȿ���� ����
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		//2�ܰ�: ��û�� �м��Ѵ�(� ��û�� ������ �𸣴ϱ�)
		String uri=request.getRequestURI();
		String msg = null;
		
		RequestDispatcher dis = null;
		
		//���� �����ڴ� �ʹ� ���� ����~! �׷��� ������ ���� ��Ʈ�ѷ��� ���� �³����� �й踸 ����~!
		
		Controller controller = null;

		//3�ܰ�: �˸´� ���� ��ü�� �� ��Ų��!!
		//if(uri.equals("/blood.do")){			
			try {
				Class controllerClass = Class.forName((String)jsonObject.get(uri));
				controller = (Controller)controllerClass.newInstance();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			controller.execute(request, response);	
			 
			//controller = new BloodController();
			
		//}else if(uri.equals("/movie.do")){
			
//			try {
//				Class controllerClass = Class.forName("mvc.controller.MovieController");
//				controller = (Controller)controllerClass.newInstance();
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			} catch (InstantiationException e) {
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				e.printStackTrace();
//			}
//			
			//controller = new MovieController();
			
			//String movie = request.getParameter("movie");
			//MovieAdviser adviser = new MovieAdviser();
			//msg = adviser.getAdvice(movie);
			
			//4�ܰ�: ��� ����
			//request.setAttribute("data", msg);
			//dis = request.getRequestDispatcher("/movie/result.jsp");
	//	}
	//	controller.execute(request, response);		
		//dis.forward(request, response);
	}
	
	
	
	public void destroy() {
		if(fis!=null){
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
