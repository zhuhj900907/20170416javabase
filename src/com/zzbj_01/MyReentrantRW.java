package com.zzbj_01;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/****
 * 读写锁
 * 
 * @author huijun
 * 
 */
public class MyReentrantRW {
	/**
	 * 读写锁
	 */
	private ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();

	/****
	 * 读的方法
	 * 
	 * @param thread
	 */
	public void get(Thread thread) {
		rw1.readLock().lock();
		try {
			long start = System.currentTimeMillis();
			while (System.currentTimeMillis() - start <= 1) {
				System.out.println(thread.getName() + "----正在进行读操作");
			}
			System.out.println(thread.getName() + ">>>>正在进行写操作");
		} finally {
			System.out.println(thread.getName() + "++++读操作完毕");
			rw1.readLock().unlock();
		}
	}

	/****
	 * 写的方法操作写的锁
	 * 
	 * @param thread
	 */
	public void write(Thread thread) {
		rw1.writeLock().lock();
		try {
			long start = System.currentTimeMillis();
			while (System.currentTimeMillis() - start <= 1) {
				System.out.println(thread.getName() + ">>>>正在进行写操作");
			}
			System.out.println(thread.getName() + "----正在进行读操作");
		} finally {
			System.out.println(thread.getName() + "++++写操作完毕");
			rw1.writeLock().unlock();
		}
	}

	/****
	 * 主函数操作的地方
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final MyReentrantRW test = new MyReentrantRW();
		new Thread() {
			public void run() {
				test.get(Thread.currentThread());
				test.write(Thread.currentThread());
			}
		}.start();

		new Thread() {
			public void run() {
				test.get(Thread.currentThread());
				test.write(Thread.currentThread());
			}
		}.start();
	}
}
