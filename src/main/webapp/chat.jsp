<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script type="text/javascript" src="/chat/resources/js/jquery/jquery-3.2.1.min.js" ></script>
<title>聊天室</title>
</head>
<body>
<div id="chatWin" style="width: 300px; height: 100px; border: solid 1px; overflow: auto;" >
	<ul id="message" style="list-style: none;" >
		
	</ul>
</div>
<div style="width: 300px" ><input id="content" type="text" style="width: 243px;" ><input id="send" type="button" value="发送" style="width: 51px;" ></div>
</body>
<script type="text/javascript">
	var ws = null;
	if (WebSocket)
	{
		// 建立websocket连接
		ws = new WebSocket("ws://localhost:8088/chat/chat");
	}
	else
	{
		alert("浏览器不支持websocket调用");
	}
	
	ws.onopen = function(){
		ws.send("[${nickname}]进入聊天室");
	}
	
	ws.onmessage = function(event){
		$("#message").append($("<li>" + event.data + "</li>"));
		
		// 来到窗口的最新位置
		$("#chatWin").scrollTop($('#chatWin')[0].scrollHeight);
		
	}
	
	$("#send").click(function(){
		var content = $("#content").val();
		if (content.length > 0){
			
			ws.send("${nickname}: " + content);
			$("#content").val("");
		}
		else{
			alert("请输入消息内容");
			$("#content").focus();
		}
		
	});
	
</script>
</html>