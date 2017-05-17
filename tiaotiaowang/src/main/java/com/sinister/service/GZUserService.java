package com.sinister.service;

import com.sinister.entity.Crecruit;
import com.sinister.entity.GZUserEntity;

public interface GZUserService {
	
	
	    //查找公司信息
	public GZUserEntity findGZUser(int id);
		
	//根据公司查找招聘信息
	public Crecruit findGZjob(String company);
		
}
