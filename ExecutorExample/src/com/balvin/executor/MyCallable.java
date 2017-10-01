package com.balvin.executor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable implements Callable<String> {

	@Override
	public String call() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Thread.currentThread().getName();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		List<Future<String>> lstFuture = new ArrayList<Future<String>>();
		Callable<String> callable = new MyCallable();
		for (int i = 0; i < 100; i++) {
			Future<String> future = executor.submit(callable);
			lstFuture.add(future);
			
		}
		for (Future<String> future : lstFuture) {
			System.out.println(new Date() +" -------- "+ future);
		}
		executor.shutdown();
	}

}
