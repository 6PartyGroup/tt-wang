package com.sinister.dao;

import com.sinister.entity.Crecruit;
import com.sinister.entity.GZUserEntity;

public interface GZUserDao {
	
    //查找公司信息
	public GZUserEntity findGZUser(int id);
	
	//根据公司查找招聘信息
	public Crecruit findGZjob(String company);
	
	
	
}
