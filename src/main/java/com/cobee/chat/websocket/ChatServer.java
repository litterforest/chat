package com.cobee.chat.websocket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat")
public class ChatServer {
	
	private Session session;
	
	@OnOpen
	public void onOpen(Session session)
	{
		this.session = session;
		System.out.println("已建立socket连接, sessionID:" + session.getId());
	}
	
	@OnClose
	public void onClose()
	{
		System.out.println("已关闭socket连接");
	}
	
	@OnMessage
	public void onMessage(String msg)
	{
		System.out.println(msg);
		try {
			this.session.getBasicRemote().sendText(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
