package com.sinister.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinister.dao.JlReciuitDao;
import com.sinister.entity.JlReciuit;
import com.sinister.service.JlReciuitService;

@Service
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
