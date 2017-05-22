/*
 * 이 클래스는 웹어플리케이션의 모든 요청을 1차적으로 받는 컨트롤러이므로, 웹상의 요청을 받으려면 서블릿으로 정의해야 한다.
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
		//jsp 에서의 application 내장객체의 자료형!
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
	
	
	//POST, GET중 어떤 방식의 요청이 들어오든 처리할 수 있어야 하므로, 실제 요청을 처리하는 메서드를 별도로 정의해놓자!!
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	public void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//1단계: 요청을 받는다.
		//System.out.println("요청이 들어왔네요");
		request.setCharacterEncoding("utf-8");
		//jsp에서의 페이지 지시영역의 효과와 같음
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		//2단계: 요청을 분석한다(어떤 요청이 들어올지 모르니깐)
		String uri=request.getRequestURI();
		String msg = null;
		
		RequestDispatcher dis = null;
		
		//내가 다하자니 너무 일이 많아~! 그래서 각각의 전담 컨트롤러를 만들어서 걔네한테 분배만 하자~!
		
		Controller controller = null;

		//3단계: 알맞는 로직 객체에 일 시킨다!!
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
			
			//4단계: 결과 저장
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
