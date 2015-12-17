package com.Eveunited.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Eveunited.bean.UserBean;
import com.Eveunited.dao.DaoImpl;
import com.Eveunited.dao.InterfaceDao;
import com.google.gson.Gson;

/**
 * 验证用户密码返回用户全部信息
 * @author Li
 *
 */
public class Checkuser extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		PrintWriter out = response.getWriter();
		InterfaceDao dao = new DaoImpl();
		
		UserBean rsuser =dao.QueryUserByUserPwd(user,pwd);
		
		if(rsuser!=null){
			Gson gson = new Gson();  
	        String result = gson.toJson(rsuser);  
	        
	        out.println(result);
		}else{
			out.println("failure");
		}
		//out.println("</HTML>");
		out.flush();
		out.close();
	}

}
