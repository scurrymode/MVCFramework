<%@page contentType="text/html;charset=utf-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function send(){
	form1.method="post";
	form1.action="/movie.do";
	form1.submit();
}

</script>
</head>
<body>
<form name="form1">
	<select name="movie">
		<option value="겟아웃">겟아웃</option>
		<option value="보스베이비">보스베이비</option>
		<option value="킹아서">킹아서</option>
		<option value="에이리언 커버넌트">에이리언 커버넌트</option>	
	</select>
</form>
<input type="button" value="전송" onClick="send()">

</body>
</html>