package com.mycompany.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/*
	JoinPoint
		|
	ProceedingJoinPoint
		- proceed() 추가 >> around에서 사용
											| before
	사용자 -------> 메소드호출 --------> proceed()
											| after

*/
public class AroundAdvice {

	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		
		//System.out.println("[BEFORE]:비즈니스 메소드 수행전에 처리할 내용...");	//before어드바이스와 동일
		String method = pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
			Object returnObj = pjp.proceed();
		stopWatch.stop();
		
		System.out.println(method+"()메소드 수행에 걸린 시간: "+stopWatch.getTotalTimeMillis()+"(ms)초");
		
		//System.out.println("[AFTER]:비즈니스 메소드 수행후에 처리할 내용...");	//after어드바이스와 동일
		
		return returnObj;
		
	}
	
}
