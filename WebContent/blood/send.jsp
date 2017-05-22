<%@page contentType="text/html;charset=utf-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function send(){
	form1.action="/blood.do";
	form1.submit();
}

</script>
</head>
<body>
<form name="form1">
	<select name="blood">
		<option value="A">A형</option>
		<option value="B">B형</option>
		<option value="AB">AB형</option>
		<option value="O">O형</option>	
	</select>
</form>
<input type="button" value="전송" onClick="send()">

</body>
</html>