package com.zzbj_03;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestPool {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Future<?> submit = null;
		Random random = new Random();
		// 创建固定数量的线程池
		ExecutorService exec = Executors.newFixedThreadPool(4);
		/* 创建调度线程池 */
		/* ScheduledExecutorService exec = Executors.newScheduledThreadPool(4); */
		// 用来记录个线程的返回结果
		ArrayList<Future<?>> results = new ArrayList<Future<?>>();
		for (int i = 0; i < 10; i++) {
			// 提交线程
			submit = exec.submit(new TaskCallable(i));
			// 存储线程的执行结果
			results.add(submit);// 回调的句柄
		}
		// 打印结果
		for (Future<?> future : results) {
			boolean done = future.isDone();
			System.out.println(done ? "已完成" : "未完成");
			// 阻塞拿结果
			System.out.println("线程返回结果:>>>>" + future.get());
		}
		exec.shutdown();
	}
}
