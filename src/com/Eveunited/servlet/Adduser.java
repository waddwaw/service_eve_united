package com.Eveunited.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Eveunited.bean.AddUserBean;
import com.Eveunited.bean.UserBean;
import com.Eveunited.dao.DaoImpl;
import com.Eveunited.dao.InterfaceDao;
import com.Eveunited.utils.MD5Encoder;
import com.google.gson.Gson;

/**
 * 新用户注册
 * 
 * @author Li
 * 
 */
public class Adduser extends HttpServlet {

	private String address="";
	private String portrait="";
	private String email="";
	private String introduce="";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InterfaceDao dao = new DaoImpl();
		PrintWriter out = response.getWriter();
		String user = request.getParameter("user");
		String nickname = request.getParameter("nickname");
		String pwd = request.getParameter("pwd");
		String number = request.getParameter("number");
		String sex = request.getParameter("sex");
		address = request.getParameter("address");
		portrait = request.getParameter("portrait");
		email = request.getParameter("email");
		introduce = request.getParameter("introduce");
		Gson gson =new Gson();
		AddUserBean addUser = new AddUserBean();   //String 类型 转JSON
		if (dao.QueryUserByUser(user) == null) {
			try {
				pwd=MD5Encoder.encode(pwd);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UserBean rsuser = new UserBean(0, user, nickname, pwd, number, sex,
					address, portrait, email, introduce, new Date().getTime()
							+ "");
			
			int reslut = dao.AddUser(rsuser);
			
			if (reslut != 0) {
				addUser.setState("success");
				out.println(gson.toJson(addUser));
			} else {
				addUser.setState("success");
				out.println(gson.toJson(addUser));
			}
		}else {
			addUser.setState("existing");
			out.println(gson.toJson(addUser));
			
		}
		out.flush();
		out.close();
	}

}
