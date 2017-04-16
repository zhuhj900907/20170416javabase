package com.zzbj_01;
/****
 * 使用synchronized实现读写锁，只能一个一个实现
 * @author huijun
 *
 */
public class MySynchorizedRW {
	
	public synchronized void get(Thread thread){
		long start = System.currentTimeMillis();
		int i = 0;
		while(System.currentTimeMillis() - start <= 1)
		{
			i++;
			if (i%4==0){
				System.out.println(thread.getName()+"******正在进行写操作");
			}else{
				System.out.println(thread.getName()+">>>>>>正在进行读操作");
			}
			System.out.println(">>>>>>读写完毕");
		}
	}
	public static void main(String[] args) {
		final MySynchorizedRW test = new MySynchorizedRW();
		new Thread(){
			public 	void run() {
				test.get(Thread.currentThread());
			}
		}.start();
		new Thread(){
			public 	void run() {
				test.get(Thread.currentThread());
			}
		}.start();
	}
}

