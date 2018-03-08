package com.cobee.chat.websocket;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat")
public class ChatServer {
	
	private Session session;
	private static CopyOnWriteArraySet<ChatServer> sets = new CopyOnWriteArraySet<ChatServer>();
	
	@OnOpen
	public void onOpen(Session session)
	{
		this.session = session;
		sets.add(this);
		System.out.println("已建立socket连接, sessionID:" + session.getId());
	}
	
	@OnClose
	public void onClose()
	{
		sets.remove(this);
		System.out.println("已关闭socket连接");
	}
	
	@OnMessage
	public void onMessage(String msg)
	{
		System.out.println(msg);
		try {
			for (ChatServer cs : sets)
			{
				cs.session.getBasicRemote().sendText(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
