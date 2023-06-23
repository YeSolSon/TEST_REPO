package com.mycompany.biz.common;

import org.aspectj.lang.JoinPoint;

/*
	JoinPoint인터페이스
		; 횡단관심에 해당하는 어드바이스(공통코드)메소드를 잘 구현하려면 클라이언트가 요청한 비즈니스 메소드의 정보를 알아야 한다.
			. 예외가 발생한 비즈니스 메소드 이름?
			. 그 메소드가 속한 클래스와 패키지 정보?
		등..이러한 정보를 이용할 수 있도록 스프링은 JoinPoint인터페이스를 제공한다.
		
		. Signature getSignature() : 클라이언트가 요청한 메소드의 시그니처(리턴타입,메소드이름,매개변수)정보가 담긴 객체
		. Object	getTarget()	   : 클라이언트가 호출한 비즈니스 메소드를 포함하고 있는 객체리턴
		. Object[] 	getArgs()	   : 클라이언트가 메소드를 호출할 때 넘겨준 인자목록
		
		Signature객체
			. String getName()		: 클라이언트가 요청한 메소드 이름 리턴
			. String toLongString()	: 클라이언트가 호출한 리턴타입, 메소드이름, 매개변수를 패키지경로까지 포함 리턴
			. String toShortString(): 호출한 메소드 시그니처를 축약한 문자열로 리턴
		
	JoinPoint객체생성과정
		- 사용자 요청 > 스프링컨테이너가 호출과 관련된 정보를 담은 JoinPoint객체를 생성 > 스프링컨테이너가 applicationContext.xml에 
		설정되어 있는 method를 호출할 때, 이 객체를 인자로 넘겨준다.
	
	동작에 따른 활용
		- Before, After들 어드바이스는 모두 - JoinPoint를 사용
		- Around어드바이스는 ProceedingJoinPoint를 사용해야 한다.
		
*/
public class BeforeAdvice {

	public void beforeLog(JoinPoint jp) {
		
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		System.out.println("[사전처리]"+method+"()메소드와 args정보: "+args[0].toString());
		
	}
}
