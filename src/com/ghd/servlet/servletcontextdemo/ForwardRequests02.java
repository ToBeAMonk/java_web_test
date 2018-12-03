package com.ghd.servlet.servletcontextdemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardRequests02 extends HttpServlet{

	public  void doGet(HttpServletRequest request,HttpServletResponse response) {
		try {
			response.getOutputStream().write("ForwardRequests02".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public  void doPost(HttpServletRequest request,HttpServletResponse response) {
		doGet(request, response);
	}
}
