package com.Eveunited.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class MangeDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<MangeDemoBean> list = new ArrayList<MangeDemoBean>();
		for (int i = 0; i < 20; i++) {
			MangeDemoBean bean = new MangeDemoBean();
			bean.setTitle("我是标题" + i);
			bean.setBody("我是内容" + i);
			list.add(bean);
		}
		String sJson = new Gson().toJson(list);
		String title = request.getParameter("title");
		if (title == null) {
			out.print(sJson);
		}else {
			for(MangeDemoBean bean :list){
				if(bean.getTitle().equals(title)){
					out.print(bean.getBody());
					break;
				}
			}
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
