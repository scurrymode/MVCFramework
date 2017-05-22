/*
 * ���� �츮�� MVC ������ ������ ���ø����̼ǿ����� ��� ��û�� �޴� �������� �ϳ��� �ΰ�, �� ��Ʈ�ѷ��� ���� ��� ��û�� ó���ϴ� ����̾���.
 * ������, �ϳ��� ��Ʈ�ѷ����� �� ������ �ϸ�, if���� �ʹ� ��������, ���������� ���������, Ŀ��Ʈ������ Ȱ���Ѵ�.
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
		//3�ܰ�
		adviser = new BloodAdviser();
	}
	
	
	//3�ܰ�: �˸´� ����Ͻ� ���� ��ü�� �� ��Ų��!!
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String blood = request.getParameter("blood");
		String msg = adviser.getAdvice(blood);
		
		//4�ܰ�: �������
		request.setAttribute("data", msg);
		
		//5�ܰ�: �����ֱ�
		RequestDispatcher dis = request.getRequestDispatcher("/blood/result.jsp");
		dis.forward(request, response);
	}

}
