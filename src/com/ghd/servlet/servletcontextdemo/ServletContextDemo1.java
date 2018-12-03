package com.ghd.servlet.servletcontextdemo;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 多个Servlet通过ServletContext对象实现数据共享
 * 这里是demo1    还有一个demo2  要先运行demo1再运行demo2
 * 否则demo2是空
 * @author MJ-G
 * @date 2018年12月1日 下午2:40:10
 */
public class ServletContextDemo1 extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		String data = "MJ_G";
		/*
		 * ServletConfig对象中维护了ServletContext对象的引用，开发人员编写servlet时，
		 * 可以通过ServletConfig.getServletContext方法获得ServletContext对象。
		 */
		ServletContext sc = this.getServletConfig().getServletContext();
		sc.setAttribute("info", data);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		doGet(request, response);
	}
}
