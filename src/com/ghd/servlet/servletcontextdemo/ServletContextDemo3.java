package com.ghd.servlet.servletcontextdemo;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取WEB应用的初始化参数
 * @author MJ-G
 * @date 2018年12月1日 下午2:40:10
 */
public class ServletContextDemo3 extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		ServletContext sc =this.getServletContext();
		String initParameter = sc.getInitParameter("url");
		try {
			response.getWriter().print("url="+initParameter);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		doGet(request, response);
	}
}
