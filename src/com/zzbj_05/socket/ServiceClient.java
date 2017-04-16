package com.zzbj_05.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*****
 * client端
 * 
 * @author huijun
 * 
 */
public class ServiceClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		// 建立连接
		Socket socket = new Socket("localhost", 8899);
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(out);
		pw.println("hello");
		pw.flush();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String param = br.readLine();
		
		System.out.println(param);
		
		in.close();
		out.close();
		socket.close();
	}
}
