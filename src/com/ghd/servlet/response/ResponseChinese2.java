package com.ghd.servlet.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 使用OutputStream流向客户端浏览器输出"中国"这两个汉字
 * @author MJ-G
 * @date 2018年12月1日 下午5:09:37
 */
public class ResponseChinese2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		//
		String str = "中国";
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		response.setHeader("content-type", "text/html;charset=UTF-8");
		//writer.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
		writer.print(str);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// 
		doGet(req, response);
	}
}
