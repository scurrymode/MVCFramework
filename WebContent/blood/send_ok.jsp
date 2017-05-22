<%@page import="mvc.model.BloodAdviser"%>
<%@page contentType="text/html;charset=utf-8"%>
<%
	//넘겨받은 파라미터를 분석하여, 알맞는 피드백 보여주기
	//Controller의 업무 영역
	//1. 요청을 받는다.
	String blood = request.getParameter("blood");
	//2. 요청을 분석한다(현재는 요청 1개라서 분석할 것이 없음)

	//3. 알맞는 로직 객체에 일 시킨다.
	BloodAdviser adviser = new BloodAdviser();
	String msg = adviser.getAdvice(blood);
	
	//4. 결과가 있다면 결과를 저장해놓는다(왜? 나와는 다른 페이지가 결과를 보여줄거라서~!)
	//요청객체에 결과물을 담는다.
	request.setAttribute("data", msg);
	
	//5. 결과를 보여준다.
	//현재 페이지에서 응답을 하지말고, 현재 요청을 다른 jsp에게 그대로 전달해보자!! = 포워딩
	RequestDispatcher dis = request.getRequestDispatcher("result.jsp");
	dis.forward(request, response);
%>