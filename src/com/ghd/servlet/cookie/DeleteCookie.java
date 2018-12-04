package com.ghd.servlet.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 当删除cookie的时间后，每次访问GetTime都是第一访问本站，可以确定，设置的时间被删除了
 * @author MJ-G
 * @date 2018年12月4日 下午3:12:15
 */
public class DeleteCookie extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//创建一个名字为lastAccessTime的cookie
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis()+"");
		//将cookie有效期设置为0，命令浏览器删除
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
