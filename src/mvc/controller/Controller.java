/*
 * 인터페이스는 하위 컨트롤러들이 모두 구현해야하는 메서드를 보유한 최상위 객체로 정의한다!
 * 최상위 객체로 정의하면 구현 강제 뿐아니라 하나의 자료형으로 묶을 수 있다.
 * */

package mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public boolean isForward();
}
