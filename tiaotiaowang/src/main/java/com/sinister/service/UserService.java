package com.sinister.service;

import java.util.List;

import com.sinister.entity.User;

public interface UserService {

	// �û���¼
	List<User> userlogin();

	// �û�ע��
	void userregister(User user);

}
