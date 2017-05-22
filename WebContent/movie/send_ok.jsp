<%@page import="mvc.model.MovieAdviser"%>
<%@page contentType="text/html;charset=utf-8"%>
<%
/*
1. 요청을 받는다
2. 요청을 분석한다(선택)
3. 알맞은 로직 객체에 일시킨다
4. 결과가 있다면 결과를 저장한다(선택)
5. 결과를 보여준다
*/
	request.setCharacterEncoding("utf-8");
	String movie = request.getParameter("movie");
	
	//3단계
	MovieAdviser adviser = new MovieAdviser();
	//4단계 - 저장
	String msg = adviser.getAdvice(movie);
	request.setAttribute("data", msg);
	
	//5단계
	RequestDispatcher dis = request.getRequestDispatcher("result.jsp");
	dis.forward(request, response);

%>