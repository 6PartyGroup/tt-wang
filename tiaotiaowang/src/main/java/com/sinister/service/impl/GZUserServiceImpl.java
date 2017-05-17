package com.sinister.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinister.dao.GZUserDao;
import com.sinister.entity.Crecruit;
import com.sinister.entity.GZUserEntity;
import com.sinister.service.GZUserService;

@Service
public class GZUserServiceImpl implements GZUserService{

	@Resource
	private GZUserDao gzuserdao;
	
	public GZUserEntity findGZUser(int id) {
		GZUserEntity entity=gzuserdao.findGZUser(id);
		return entity;
	}

	public Crecruit findGZjob(String company) {
		Crecruit crecruit = gzuserdao.findGZjob(company);
		return crecruit;
	}

	
	
	
	
	
}
