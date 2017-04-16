package com.zzbj_02;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/****
 * 固定线程池中线程的个数
 * @author huijun
 *
 */
public class FixedThreadPool {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//创建线程池
		ExecutorService pool = Executors.newFixedThreadPool(6);
		for (int i = 0; i < 20; i++) {
			Future<String> submit = pool.submit(new Callable<String>() {

				@Override
				public String call() throws Exception {
					Thread.sleep(2000);
					// TODO Auto-generated method stub
					return "b>>>>"+Thread.currentThread().getName();
				}
			});
			System.out.println("b>>>>"+i);
			//从future中获得数据是阻塞的
			//System.out.println(submit.get());
		}
		pool.shutdown();
	}
}
