package com.balvin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SampleExecutor {

	private static ExecutorService executor = null;
	private static volatile Future<Long> res1 = null;
	private static volatile Future<Long> res2 = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		executor = Executors.newFixedThreadPool(2);
		
		while(true) {
			try {
				checkTasks();Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	private static void checkTasks() throws Exception{
		
		if(res1 == null || res1.isDone() ||res1.isCancelled()) {
			res1 = executor.submit(new Test1());
			
		}
		if(res2 == null || res2.isDone() ||res2.isCancelled()) {
			res2 = executor.submit(new Test2());
			
		}
		
		res1.get();
		res2.get();
		//executor.shutdown();
	}

}
