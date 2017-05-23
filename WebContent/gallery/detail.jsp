<%@page import="gallery.model.Gallery"%>
<%@ page contentType="text/html;charset=utf-8"%>
<% 
	String gallery_id = request.getParameter("gallery_id");
	Gallery dto=(Gallery)request.getAttribute("gallery");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
#box{border:1px solid #CCCCCC}
#writer,#title,#content{font-size:9pt;font-weight:bold;color:#7F7F7F;돋움}
input{
	font-size:9pt;
	border-left:1px solid #C3C3C3;
	border-top:1px solid #C3C3C3;
	border-right:1px solid #C3C3C3;
	border-bottom:1px solid #C3C3C3;
	color:#7F7F7F;돋움
}
#title input{width:250px;}
#content textarea{
width:503px;
border:0;
height:153;
background:url("/board/images/write_bg.gif");
border:#C3C3C3 1px solid 
}
#copyright{font-size:9pt;}
a{text-decoration:none}
img{border:0px}
</style>
<script>
	//에딧도 요청만 할 수 있지만, get으로 보내기엔 너무 많다~ 그래서 post
	function edit(){
		if(confirm("정말 수정하실래요?")){
			form1.action="/gallery/edit.do";
			form1.submit();
		}
	}
	
	function del(){
		//여기서는 삭제를 할 수 없고 삭제를 요청만 할 수 있다.
		if(confirm("정말 삭제하실래요?")){
			location.href="/gallery/delete.do?gallery_id=<%= gallery_id %>";
		}
	}
	
	
	
</script>
</head>
<body>
<form name="form1" method="post">
<input type="hidden" name="gallery_id" value="<%=gallery_id %>">
<table id="box" align="center" width="603" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="/board/images/ceil.gif" width="603" height="25"></td>
  </tr>
  <tr>
    <td height="2" bgcolor="#6395FA"><img src="/board/images/line_01.gif"></td>
  </tr>
  <tr>
    <td height="1" bgcolor="#CCCCCC"></td>
  </tr>
	<tr>	
		<td id="list"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="100">&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr id="writer">
            <td height="25" align="center">작성자</td>
            <td><input type="text" name="writer" value="<%= dto.getWriter() %>"></td>
          </tr>
          <tr id="title">
            <td height="25" align="center">제목</td>
            <td><input type="text" name="title" value="<%= dto.getTitle() %>"></td>
          </tr>
          <tr id="content">
            <td align="center">내용</td>
            <td><textarea name="content" style="" ><%= dto.getContent() %></textarea></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
	</tr>
  <tr>
    <td height="30" align="right" style="padding-right:2px;">
	<img src="/board/images/write_btin.gif" width="61" height="20" onClick="edit()">
	<img src="/board/images/delete_btn.gif" width="61" height="20" onClick="del()"> <a href="/gallery/list.do"><img src="/board/images/list_btn.gif" width="61" height="20" border="0"></a> </td>
  </tr>
  <tr>
    <td height="1" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="20" align="center" id="copyright">Copyright zino All Rights Reserved </td>
  </tr>
</table>
</form>
</body>
</html>
