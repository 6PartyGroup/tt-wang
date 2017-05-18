package com.sinister.service;

import com.sinister.entity.Crecruit;
import com.sinister.entity.GZUserEntity;

public interface GZUserService {
	
	
	//查找公司信息
	public GZUserEntity findGZUser(int id);
		
	//根据公司信息表是次表  招聘信息是主表 查找招聘信息    两张表查询
	public Crecruit findGZjob(String company);
	
	//三表联查
	public Crecruit findjcr(String string);
	
	//查找招聘信息表
	public Crecruit findcrecruit(int id);
		
}
