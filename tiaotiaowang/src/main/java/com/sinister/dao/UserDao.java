package com.sinister.dao;

import java.util.List;

import com.sinister.entity.User;

public interface UserDao {

	// �û���¼
	List<User> userlogin();

	// �û�ע��
	void userregister(User user);

}
