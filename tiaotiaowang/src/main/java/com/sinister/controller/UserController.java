package com.sinister.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinister.entity.User;
import com.sinister.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	// �û���¼
	@RequestMapping("sl_userlogin.do")
	@ResponseBody
	public String userLogin(@RequestBody User user,HttpServletRequest request) {
		List<User> list = userService.userlogin();
		HttpSession session=request.getSession();
		for (User u : list) {
			if (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
				session.setAttribute("uid", u.getUid());
				return "success";
			}
		}
		return "fail";
	}

	// �û�ע��
	@RequestMapping("sl_userregister.do")
	@ResponseBody
	public String userRegister(@RequestBody User user) {
		//haha
		// ����û����Ƿ��ظ�
		List<User> list = userService.userlogin();
		for (User u : list) {
			if (u.getUsername().equals(user.getUsername())) {
				return "exise";
			}
		}

		// ע��
		userService.userregister(user);
		return "success";

	}
}
