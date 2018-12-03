package com.ghd.servlet.servletcontextdemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 在客户端缓存Servlet的输出
 * @author MJ-G
 * @date 2018年12月1日 下午4:37:38
 */
public class CacheResponse extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String data = "abcddfwerwesfasfsadf";
		/**
		 * 设置数据合理的缓存时间值，以避免浏览器频繁向服务器发送请求，提升服务器的性能
		 * 这里是将数据的缓存时间设置为1天
		 */
		resp.setDateHeader("expires",System.currentTimeMillis() + 24 * 3600 * 1000);
		resp.getOutputStream().write(data.getBytes());
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
