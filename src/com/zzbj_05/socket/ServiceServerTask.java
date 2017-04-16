package com.zzbj_05.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServiceServerTask implements Runnable {
	Socket socket;
	InputStream in = null;
	OutputStream out = null;

	public ServiceServerTask(Socket socket) {
		this.socket = socket;
	}

	// 业务逻辑也客户端交互
	@Override
	public void run() {
		try {
			in = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			out = socket.getOutputStream();
			// 需要加回车
			/*
			 * String line=""; while((line =br.readLine()) != null) {
			 * 
			 * }
			 */
			String param = br.readLine();
			System.out.println("server>receive>client----:"+param);
			GetDataServiceImpl impl = new GetDataServiceImpl();
			String res = impl.getData(param);
			PrintWriter pw = new PrintWriter(out);

			pw.println(res);
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
