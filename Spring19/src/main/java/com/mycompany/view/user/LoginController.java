package com.mycompany.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.mycompany.biz.user.UserVO;
import com.mycompany.biz.user.impl.UserDAO;


public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
			
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
	
		
		//세션처리
		HttpSession session = request.getSession();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject(user);
		
		if(user != null) {
			session.setAttribute("name", user.getName());

			mav.setViewName("getBoardList.do");
			return mav;
		}else {
			mav.setViewName("login.jsp");
			return mav;
		}
	}

}
