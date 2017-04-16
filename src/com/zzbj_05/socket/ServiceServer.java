package com.zzbj_05.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/****
 * 服务器端
 * 
 * @author huijun
 * 
 */
public class ServiceServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket();
		server.bind(new InetSocketAddress("localhost", 8899));
		// 接收客户端的链接,accept是阻塞链接
		while(true){
			Socket socket = server.accept();
			new Thread(new ServiceServerTask(socket)).start();
		}

	}
}
