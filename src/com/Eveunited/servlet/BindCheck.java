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

public class BindCheck extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String num = request.getParameter("num");

		InterfaceDao dao = new DaoImpl();
		UserBean user = dao.QueryUserByNubmer(num);
		

		if (user != null) {
			
			if (dao.CheckBind(user.getUser())) {
				out.print("failure");
			}else {
				out.print(user.getUser());
			}
		} else {
			out.print("failure");
		}

		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
