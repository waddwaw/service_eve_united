package com.Eveunited.service;

import java.io.IOException;
import java.util.ArrayList;

import com.Eveunited.bean.SocketBean;

public class MySocketMessage {
	public static ArrayList<SocketBean> mSocketList = new ArrayList<SocketBean>();
	//加入synchronized  防止多个用户下线出现 数组越界情况
	public static synchronized void  Del(String user){
		for(int i = 0;i<mSocketList.size();i++){
			SocketBean socket = mSocketList.get(i);
			if(socket.getUser().equals(user)){
				try {
					mSocketList.remove(i).getmSocket().close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}
}
