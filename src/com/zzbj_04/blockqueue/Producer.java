package com.zzbj_04.blockqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	Random random = new Random();
	BlockingQueue<String> queue;
	private String pname;

	/***
	 * 构造函数
	 * 
	 * @param queue
	 */
	public Producer(BlockingQueue<String> queue, String productname) {
		this.queue = queue;
		pname = productname;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(random.nextInt(10)*1000);
			System.out.println("I have made a product:" + Thread.currentThread().getName());
			String temp = pname + " Product , 生产线程:" + Thread.currentThread().getName();
			queue.put(temp);//如果队列满的话会阻塞进程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
