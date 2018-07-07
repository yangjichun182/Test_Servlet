package com.pactera.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo1 extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");

		Cookie[] cs = request.getCookies();
		Cookie findC = null;
		if (cs != null) {
			for (Cookie c : cs) {
				if ("lastTime".equals(c.getName())) {
					findC = c;
				}
			}
		}
		if (findC == null) {
			response.getWriter().write("您是第一次访问本网站!");
		} else {
			Long lastTime = Long.parseLong(findC.getValue());
			response.getWriter().write(
					"您上次访问时间是:" + new Date(lastTime).toLocaleString());
		}

		Date date = new Date();
		Cookie c = new Cookie("lastTime", date.getTime() + "");
		c.setMaxAge(3600 * 24 * 30);
		c.setPath(request.getContextPath());
		// c.setDomain(".baidu.com");
		response.addCookie(c);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
