package com.ghd.servlet.servletcontextdemo;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 利用ServletContext对象读取资源文件
 * 
 * @author MJ-G
 * @date 2018年12月1日 下午3:44:11
 */
public class ServletContextReadSource01 extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpServletResponse response = ((HttpServletResponse)resp);
		response.setHeader("content-type","text/html;charset=UTF-8");
		readPropCfgFile(resp);//读取src目录下的properties配置文件
		response.getWriter().println("\r\n");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	/**
	 *读取src下的db.properties
	 * @param req
	 * @param resp
	 */
	private void readPropCfgFile(HttpServletResponse resp) {
		//this.getServletContext().getResourceAsStream("/WEB-INF/classes/db1.properties");这种当使用tomcat时，是正确的，但是用jetty的嵌入式是不行的,
		InputStream in = Thread.currentThread().getContextClassLoader()  
                .getResourceAsStream("db.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = prop.getProperty("jdbc_url");
		String username = prop.getProperty("user");
		String password = prop.getProperty("password");
		try {
			resp.getWriter().println("读取src目录下的db1.properties配置文件：");
			resp.getWriter().println(
					MessageFormat.format(
							"url={0},username={1},password={2}", 
							url, username, password));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
