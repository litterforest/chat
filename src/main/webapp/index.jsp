<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="utf-8" >
<title>登录</title>
</head>
<body>
	<div>
		<form action="/chat/LoginServlet" method="post" >
			<p><input name="nickname" ></p>
			<p><input type="submit" value="登录聊天室" ></p>
		</form>
	</div>
</body>
<!-- <script type="text/javascript">
	var websocket = new WebSocket("ws://localhost:8088/chat/chat");
</script> -->
</html>