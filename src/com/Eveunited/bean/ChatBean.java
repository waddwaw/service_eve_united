package com.Eveunited.bean;

/**
 * type为0 表示为普通消息  为1表示 图片路径 为2表示语音路径
 * @author Li
 *
 */

public class ChatBean {
	private String user;
	private String type;
	private String content;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ChatBean(String user, String type, String content) {
		super();
		this.user = user;
		this.type = type;
		this.content = content;
	}
	
	
}
