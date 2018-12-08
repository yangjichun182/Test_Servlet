package com.jichun.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8954369601532910812L;

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
	@SuppressWarnings("deprecation")
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
			response.getWriter().write("���ǵ�һ�η��ʱ���վ!");
		} else {
			Long lastTime = Long.parseLong(findC.getValue());
			response.getWriter().write(
					"���ϴη���ʱ����:" + new Date(lastTime).toLocaleString());
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
