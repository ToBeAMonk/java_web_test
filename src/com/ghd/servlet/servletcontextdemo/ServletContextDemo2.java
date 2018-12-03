package com.ghd.servlet.servletcontextdemo;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 多个Servlet通过ServletContext对象实现数据共享
 * @author MJ-G
 * @date 2018年12月1日 下午2:40:10
 */
public class ServletContextDemo2 extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		ServletContext sc = this.getServletConfig().getServletContext();
		String data= (String) sc.getAttribute("info");
		 try {
			response.getWriter().print("data="+data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		doGet(request, response);
	}
}
