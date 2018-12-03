package com.ghd.servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;
//这是用字节流
public class WebContextStart {

	public static void main(String[] args) {
		Server server = new Server();
		ServerConnector connector = new ServerConnector(server);
		connector.setPort(8080);
		server.addConnector(connector);
		WebAppContext context1 = new WebAppContext();  
		// 设置描述符位置  
		context1.setDescriptor("./webContent/WEB-INF/web.xml");     
		// 设置Web内容上下文路径  
		context1.setResourceBase("./webContent");  
		// 设置上下文路径  
		context1.setContextPath("/java_web_test");  
		context1.setParentLoaderPriority(true);  
		server.setHandler(context1);  
		try {
			server.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
