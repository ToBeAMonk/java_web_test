package com.ghd.servlet.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 这个servlet是表述一些request的一些常用的get方法
 * @author MJ-G
 * @date 2018年12月4日 下午2:17:42
 */
public class RequestGetMethod extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 /**
		   * 1.获得客户机信息
		   */
		  String reqUrl = req.getRequestURL().toString();//得到请求的URL地址
		  String reqUri = req.getRequestURI();//得到请求的资源
		  String queryString = req.getQueryString();//得到请求的URL地址中附带的参数
		  String remoteAddr = req.getRemoteAddr();//得到来访者的IP地址
		  String remoteHost = req.getRemoteHost();
		  int remotePort = req.getRemotePort();
		  String remoteUser = req.getRemoteUser();
		  String method = req.getMethod();//得到请求URL地址时使用的方法
		  String pathInfo = req.getPathInfo();
		  String localAddr = req.getLocalAddr();//获取WEB服务器的IP地址
		  String localName = req.getLocalName();//获取WEB服务器的主机名
		  resp.setCharacterEncoding("UTF-8");//设置将字符以"UTF-8"编码输出到客户端浏览器
		  //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
		  resp.setHeader("content-type", "text/html;charset=UTF-8");
		  PrintWriter out = resp.getWriter();
		  out.write("获取到的客户机信息如下：");
		  out.write("<hr/>");
		  out.write("请求的URL地址："+reqUrl);
		  out.write("<br/>");
		  out.write("请求的资源："+reqUri);
		  out.write("<br/>");
		  out.write("请求的URL地址中附带的参数："+queryString);
		  out.write("<br/>");
		  out.write("来访者的IP地址："+remoteAddr);
		  out.write("<br/>");
		  out.write("来访者的主机名："+remoteHost);
		  out.write("<br/>");
		  out.write("使用的端口号："+remotePort);
		  out.write("<br/>");
		  out.write("remoteUser："+remoteUser);
		  out.write("<br/>");
		  out.write("请求使用的方法："+method);
		  out.write("<br/>");
		  out.write("pathInfo："+pathInfo);
		  out.write("<br/>");
		  out.write("localAddr："+localAddr);
		  out.write("<br/>");
		  out.write("localName："+localName);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
