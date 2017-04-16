package com.zzbj_03;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/***
 * 调度的使用
 * @author huijun
 *
 */
public class TestPool2 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Future<?> submit = null;
		Random random = new Random();
		/* 创建调度线程池 */
		ScheduledExecutorService exec = Executors.newScheduledThreadPool(4);
		// 用来记录个线程的返回结果
		ArrayList<Future<?>> results = new ArrayList<Future<?>>();
		for (int i = 0; i < 10; i++) {
			// 提交线程
			submit = exec.schedule(new TaskCallable(i), random.nextInt(10),TimeUnit.SECONDS);
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
