package com.ghd.servlet.servletcontextdemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 用servletContext实现请求转发
 * 访问ForwardRequests01转发到ForwardRequests02，并且显示ForwardRequests02内容
 * @author MJ-G
 * @date 2018年12月1日 下午3:41:45
 */
public class ForwardRequests01 extends HttpServlet{

	public  void doGet(HttpServletRequest request,HttpServletResponse response) {
		String data = "<h1><font color='red'>abcdefghjkl</font></h1>";
		try {
			response.getOutputStream().write(data.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ServletContext context = this.getServletContext();//获取ServletContext对象
		RequestDispatcher rd = context.getRequestDispatcher("/servlet/ForwardRequests02");//获取请求转发对象(RequestDispatcher)
		try {
			rd.forward(request, response);//调用forward方法实现请求转发
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public  void doPost(HttpServletRequest request,HttpServletResponse response) {
		
	}
}
