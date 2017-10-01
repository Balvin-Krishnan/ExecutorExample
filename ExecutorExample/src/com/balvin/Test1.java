package com.balvin;

import java.util.concurrent.Callable;

public class Test1 implements Callable<Long>{
	public Long call() {
		System.out.println("Exector 1");
		Long i = 0L;
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}