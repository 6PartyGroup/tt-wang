package com.sinister.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinister.dao.UserDao;
import com.sinister.entity.User;
import com.sinister.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public List<User> userlogin() {
		return userDao.userlogin();
	}

	public void userregister(User user) {
		userDao.userregister(user);
	}

}
