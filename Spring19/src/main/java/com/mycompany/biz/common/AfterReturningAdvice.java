package com.mycompany.biz.common;

public class AfterReturningAdvice {

	public void afterLog() {
		System.out.println("[사후처리]비즈니스로직 수행 후 동작");
	}
}
