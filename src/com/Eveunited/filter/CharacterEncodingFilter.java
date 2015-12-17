package com.Eveunited.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CharacterEncodingFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		MyCharacterEncodingRequest requestWrapper = new MyCharacterEncodingRequest(
				request);
		chain.doFilter(requestWrapper, response);

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}
}

class MyCharacterEncodingRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request;

	public MyCharacterEncodingRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {

		try {
			String value = this.request.getParameter(name);
			if (value == null) {
				return null;
			}

			if (!this.request.getMethod().equalsIgnoreCase("get")) {
				return value;
			}

			value = new String(value.getBytes("UTF-8"),
					this.request.getCharacterEncoding());
			
			return value;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
