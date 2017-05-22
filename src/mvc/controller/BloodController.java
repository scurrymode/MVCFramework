/*
 * 현재 우리의 MVC 패턴을 적용한 어플리케이션에서는 모든 요청을 받는 진입점을 하나로 두고, 이 컨트롤러에 의해 모든 요청을 처리하는 방식이었다.
 * 하지만, 하나의 컨트롤러에서 다 업무를 하면, if문이 너무 많아지고, 유지보수가 힘들어지니, 커맨트패턴을 활용한다.
 * */
package mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.model.BloodAdviser;

public class BloodController implements Controller{
	BloodAdviser adviser;
	
	public BloodController() {
		//3단계
		adviser = new BloodAdviser();
	}
	
	
	//3단계: 알맞는 비즈니스 로직 객체에 일 시킨다!!
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String blood = request.getParameter("blood");
		String msg = adviser.getAdvice(blood);
		
		//4단계: 결과저장
		request.setAttribute("data", msg);
		
		//5단계: 보여주기
		RequestDispatcher dis = request.getRequestDispatcher("/blood/result.jsp");
		dis.forward(request, response);
	}

}
