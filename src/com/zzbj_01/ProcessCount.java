package com.zzbj_01;

public class ProcessCount {
	/****
	 * 获得线程的数量
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(">>>>>>>>>>" + Runtime.getRuntime().availableProcessors());
	}
}
