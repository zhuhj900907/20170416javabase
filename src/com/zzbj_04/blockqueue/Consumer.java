package com.zzbj_04.blockqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/****
 * 消费者
 * 
 * @author huijun
 * 
 */
public class Consumer implements Runnable {
	BlockingQueue<String> queue;
	Random random = new Random();
	/***
	 * 构造函数
	 * 
	 * @param queue
	 */
	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(random.nextInt(10)*1000);
			String consumer = Thread.currentThread().getName();
			System.out.println(consumer);
			String temp = queue.take();
			System.out.println(consumer+" get a product >>>>"+temp);//如果队列为空会阻塞进程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
