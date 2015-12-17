package com.Eveunited.service;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.servlet.ServletContext;

import com.Eveunited.bean.ChatBean;
import com.Eveunited.bean.SocketBean;
import com.Eveunited.dao.DaoImpl;
import com.Eveunited.dao.InterfaceDao;
import com.google.gson.Gson;

public class ProcessSocketData extends Thread {
	private Socket socket;
	private ServletContext servletContext;
	private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
	private boolean isOK = true; // 用于结束接收消息
	private boolean isOnline = false;// 用于判断是否在线
	private String tmp;
	private String user;

	public ProcessSocketData(Socket socket, ServletContext servletContext) {
		this.socket = socket;
		this.servletContext = servletContext;
	}

	@Override
	public void run() {
		super.run();
		try {
			dataInputStream = new DataInputStream(socket.getInputStream());

			 dataOutputStream = new DataOutputStream(socket.getOutputStream());
			// 第一次接受用户信息保存用户名称
			 user = dataInputStream.readUTF();
			
			 MySocketMessage.mSocketList.add(new SocketBean(user, socket));
			 System.out.println("Socket池大小："+MySocketMessage.mSocketList
						.size());
			 dataOutputStream.writeUTF("success");
			// System.out.println("成功向集合中添加USER");
			 new Thread(new Runnable() {
				@Override
				public void run() {
					// 循环接受用户消息 直到 isOk 为 false
					while (isOK) {
						try {
							//System.out.println("我进了准备发送的状态");
							tmp = dataInputStream.readUTF();
							ChatBean chat = new Gson().fromJson(tmp, ChatBean.class);
							
							System.out.println(tmp+"---");
							//chat.type 类型为3 需要向数据库插入绑定信息
							if(chat.getType().equals("3")){
								InterfaceDao dao = new DaoImpl();
								dao.AddBind(chat.getUser(), chat.getContent());
								dao.AddBind(chat.getContent(), chat.getUser());
							}
							for (SocketBean socket : MySocketMessage.mSocketList) {
								if (socket.getUser().equals(chat.getUser())) {
									isOnline = true;
									DataOutputStream out = new DataOutputStream(
											socket.getmSocket()
													.getOutputStream());
									out.writeUTF(tmp);
								}
							}
							// 用户不在线消息将存入数据库
							if (!isOnline) {

							}
							isOnline = false;// 消息发送对方后重置用户在线状态
						
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							MySocketMessage.Del(user);
							isOK=false;
							System.out.println("我错了2222222---------------");
							System.out.println("Socket池大小："+MySocketMessage.mSocketList
									.size());
						}
					}
				}
			}).start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MySocketMessage.Del(user);
			isOK=false;
			System.out.println("我错了---------------");
			System.out.println("Socket池大小："+MySocketMessage.mSocketList
					.size());
		}
	}
}
