package com.ghd.servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetTime extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置服务端以UTF-8编码进行输出
		resp.setCharacterEncoding("UTF_8");
		//设置浏览器以UTF-8编码进行接收，解决中文乱码
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out =resp.getWriter();
		//获取浏览器访问服务器的传递过来的cookie数组
		Cookie[] cookies=req.getCookies();
		//如果用户是第一次访问，那么得到的cookie将是null
		if(cookies!=null) {
			out.write("你上次访问的时间是：");
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if(cookie.getName().equals("lastAccessTime")) {
					Long lastAccessTime=Long.parseLong(cookie.getValue());
					Date date = new Date(lastAccessTime);
					out.write(date.toLocaleString());
				}
			}
		}else {
			out.write("这是你第一次登录本站!!");
		}
		
		//用户访问过之后，重新设置用户的访问时间，存到cookie之中，然后发送给客户端浏览器
		Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		//设置Cookie的有效期为1天
		cookie.setMaxAge(24*60*60);
		//将cookie对象添加到response对象中，这样服务器在输出response对象中的内容时，就会把cookie输出到浏览器段
		resp.addCookie(cookie);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
