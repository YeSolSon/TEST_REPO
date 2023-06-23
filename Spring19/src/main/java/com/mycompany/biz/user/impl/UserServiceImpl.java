package com.mycompany.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserService userDAO;

	
	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}


	@Override
	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
		
	}


	@Override
	public void updateUser(UserVO vo) {
		userDAO.updateUser(vo);
		
	}


	@Override
	public void deleteUser(UserVO vo) {
		userDAO.deleteUser(vo);
		
	}


	@Override
	public List<UserVO> getUserList() {
		
		return userDAO.getUserList();
	}
	
	
}
