package com.sinister.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinister.dao.JlReciuitDao;
import com.sinister.entity.JlReciuit;
import com.sinister.service.JlReciuitService;

public class JlReciuitServiceImpl implements JlReciuitService{

	@Autowired
	private JlReciuitDao jlReciuitDao ;
	
	/**
	 * service调用Dao保存招聘信息
	 */
	public void JlSaveReciuit(JlReciuit jlReciuit) {
		jlReciuitDao.JlSaveReciuit(jlReciuit);
	}

}
