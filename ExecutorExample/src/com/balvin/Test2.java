package com.balvin;

import java.util.concurrent.Callable;

public class Test2 implements Callable<Long>{
public Long call() {
	Long j = 100L;
	System.out.println("Inside Test 2");
	try {
		Thread.sleep(500);
	}catch(Exception e) {
		e.printStackTrace();
	}
	return j;
}
}
