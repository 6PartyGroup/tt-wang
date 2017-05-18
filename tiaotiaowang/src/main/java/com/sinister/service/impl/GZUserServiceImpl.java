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
	
	
	//查找公司信息
	public GZUserEntity findGZUser(int id) {
		GZUserEntity entity=gzuserdao.findGZUser(id);
		return entity;
	}
	//根据公司信息表是次表  招聘信息是主表 查找招聘信息    两张表查询
	public Crecruit findGZjob(String company) {
		Crecruit crecruit = gzuserdao.findGZjob(company);
		return crecruit;
	}
	//三表联查
	public Crecruit findjcr(String string) {
		Crecruit crecruit =gzuserdao.findjcr(string);
		return crecruit;
	}
	
	//查找招聘信息表
	public Crecruit findcrecruit(int id) {
			Crecruit crecruit = gzuserdao.findcrecruit(id);
			return crecruit;
	}


	
	
	
	
	
}
