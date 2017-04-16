package com.zzbj_02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/****
 * 
 * @author huijun
 * 
 */
public class ThreadPoolWinthRunnable {
	public static void main(String[] args) {
		//创建线程池
		ExecutorService pool = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			pool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("threadname----" + Thread.currentThread().getName());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		pool.shutdown();
	}
}
