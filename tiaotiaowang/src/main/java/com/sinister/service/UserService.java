package com.sinister.service;

import java.util.List;

import com.sinister.entity.User;

public interface UserService {

	// 用户登录
	List<User> userlogin();

	// 用户注册
	void userregister(User user);

}
