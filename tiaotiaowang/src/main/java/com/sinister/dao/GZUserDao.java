package com.sinister.dao;

import com.sinister.entity.Crecruit;
import com.sinister.entity.GZUserEntity;
import com.sinister.entity.JlRecord;

public interface GZUserDao {
	
    //查找公司信息
	public GZUserEntity findGZUser(int id);
	//根据公司名字查找公司信息
	public GZUserEntity findcomss(String string);
	
	//根据公司信息表是次表  招聘信息是主表 查找招聘信息    两张表查询
	public Crecruit findGZjob(String company);

	//三表联查
	public Crecruit findjcr(String string);
	
	//查找招聘信息表
	public Crecruit findcrecruit(int id);
	
	//保存投递简历信息
	public void gasaveuser(JlRecord jlrecord);
	
}
