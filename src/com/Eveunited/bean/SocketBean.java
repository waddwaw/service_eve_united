package com.Eveunited.bean;

import java.net.Socket;

public class SocketBean {
	private Socket mSocket;
	private String user;
	public Socket getmSocket() {
		return mSocket;
	}
	public void setmSocket(Socket mSocket) {
		this.mSocket = mSocket;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public SocketBean(String user,Socket mSocket) {
		super();
		this.mSocket = mSocket;
		this.user = user;
	}
	
}
