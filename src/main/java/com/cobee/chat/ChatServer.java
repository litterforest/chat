package com.cobee.chat;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat")
public class ChatServer {
	
	@OnOpen
	public void onOpen(Session session)
	{
		System.out.println("已建立socket连接, sessionID:" + session.getId());
	}
	
	@OnClose
	public void onClose(Session session)
	{
		System.out.println("已关闭socket连接, sessionID:" + session.getId());
	}
	
}
