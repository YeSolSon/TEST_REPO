package com.mycompany.biz.user;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.mycompany.biz.user.impl.UserService;

public class UserServiceClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)container.getBean("userService");
		
		UserVO vo = new UserVO();
		
		 vo.setId("yesol"); 
		 vo.setPassword("1234");
		 
		 UserVO user = userService.getUser(vo); 
		 if(user!=null) {
			 System.out.println(user.getName()+"님 환영합니다."); 
		 }else {
			 System.out.println("로그인실패"); }
		  
		 
			/*
			 * vo.setId("test5"); vo.setPassword("1234"); vo.setName("test5");
			 * vo.setRole("연구원"); userService.insertUser(vo);
			 * 
			 * ArrayList<UserVO> user = (ArrayList)userService.getUserList(); for(UserVO
			 * users: user) { System.out.println(users.toString()); }
			 * 
			 */
		 
		
		container.close();
	}
}
