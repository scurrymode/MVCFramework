<%@page import="gallery.model.Gallery"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	//DAO를 이용하여 레코드 가져오자!
	List<Gallery> list = (List)request.getAttribute("list");
%>

<%
	int currentPage=1;//현재 페이지(3)
	if(request.getParameter("currentPage")!=null){
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	int totalRecord=list.size();//총 레코드 수(1)
	int pageSize=10;//페이지당 보여질 레코드 수(2)
	int totalPage=(int)Math.ceil((float)totalRecord/pageSize);//총 페이지 수(4) 
	int blockSize=10; //블럭 당 보여질 페이지 수(5)
	int firstPage=currentPage-(currentPage-1)%blockSize; //블럭 당 시작 페이지(6)
	int lastPage=firstPage+blockSize-1; //블럭 당 마지막 페이지(7)
	int curPos=(currentPage-1)*pageSize;//페이지당 시작 index(ArrayList 내)(9) 커서포지션
	int num=totalRecord-curPos;//페이지당 시작번호(8)
%>

<%="currentPage = "+currentPage+"<br>" %>
<%="totalRecord = "+totalRecord+"<br>" %>
<%="pageSize = "+pageSize+"<br>" %>
<%="totalPage = "+totalPage+"<br>" %>
<%="blockSize = "+blockSize+"<br>" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
#box{border:1px solid #CCCCCC}
#title{font-size:9pt;font-weight:bold;color:#7F7F7F;돋움}
#category{font-size:9pt;color:#7F7F7F;돋움}
#keyword{
	width:80px;
	height:17px;
	font-size:9pt;
	border-left:1px solid #333333;
	border-top:1px solid #333333;
	border-right:1px solid #333333;
	border-bottom:1px solid #333333;
	color:#7F7F7F;돋움
}
#paging{font-size:9pt;color:#7F7F7F;돋움}
#list td{font-size:9pt;}
#copyright{font-size:9pt;}
a{text-decoration:none}
img{border:0px}

.pageStyle{
	font-weight:bold;
	font-size:14pt;
	color:red;
}
</style>
</head>
<body>
<table id="box" align="center" width="603" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="5"><img src="/board/images/ceil.gif" width="603" height="25"></td>
  </tr>
  <tr>
    <td height="2" colspan="5" bgcolor="#6395FA"><img src="/board/images/line_01.gif"></td>
  </tr>
  <tr id="title" align="center">
    <td width="50" height="20">번호</td>
    <td width="303" height="20">제목</td>
    <td width="100" height="20">글쓴이</td>
    <td width="100" height="20">날짜</td>
    <td width="50" height="20">조회수</td>
  </tr>
  <tr>
    <td height="1" colspan="5" bgcolor="#CCCCCC"></td>
  </tr>
	<tr>	
		<td colspan="5" id="list">
		  <table width="100%" border="0" cellpadding="0" cellspacing="0">

		    <% for(int i=0; i<pageSize; i++){ %>
		    <% if(num<1)break; %>
		    
		    <tr align="center" height="20px" onMouseOver="this.style.background='#FFFF99'" onMouseOut="this.style.background=''">

			  <td width="50"><%=num--%></td>
				<%Gallery dto = list.get(curPos++); %>
			  <td width="303"><a href="detail.do?gallery_id=<%= dto.getGallery_id()%>"><%= dto.getTitle() %></a></td>
			  <td width="100"><%= dto.getWriter() %></td>
			  <td width="100"><%= dto.getRegdate().substring(0, 10) %></td>
			  <td width="50">5</td>
		    </tr>
			<tr>
				<td height="1" colspan="5" background="/board/images/line_dot.gif"></td>
			</tr>
			<% } %>
		  </table>
		 </td>
	</tr>
  <tr>
    <td id="paging" height="20" colspan="5" align="center">
    <% if(firstPage-1>0){ %>
    <a href="/gallery/list.jsp?currentPage=<%=firstPage-1%>">◀</a>
    <% }else{ %>
    <a href="javascript:alert('처음페이지입니다');">◀</a>
    <% } %>
    <%for(int i=firstPage; i<=lastPage;i++){%>
    <% if(i>totalPage)break; %>
    <a <% if(currentPage==i) { %> class="pageStyle"<% } %> href="/gallery/list.jsp?currentPage=<%=i %>">[<%=i%>]</a><% } %>
    <% if(lastPage+1<totalPage){ %>
    <a href="/gallery/list.jsp?currentPage=<%=lastPage+1%>">▶</a>
    <%}else{ %>
    <a href="javascript:alert('마지막페이지입니다');">▶</a>
    <% } %>
    </td>
  </tr>
  <tr>
    <td height="20" colspan="5" align="right" style="padding-right:2px;">
	<table width="160" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="70">
          <select name="select" id="category">
            <option>제목</option>
            <option>내용</option>
            <option>글쓴이</option>
          </select>        </td>
        <td width="80">
          <input name="textfield" id="keyword" type="text" size="15">        </td>
        <td><img src="/board/images/search_btn.gif" width="32" height="17"></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="30" colspan="5" align="right" style="padding-right:2px;"><a href="write.jsp"><img src="/board/images/write_btin.gif" width="61" height="20" border="0"></a></td>
  </tr>
  <tr>
    <td height="1" colspan="5" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="20" colspan="5" align="center" id="copyright">Copyright zino All Rights Reserved </td>
  </tr>
</table>
</body>
</html>
