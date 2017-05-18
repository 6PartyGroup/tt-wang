package com.sinister.dao;

import java.util.List;

import com.sinister.entity.JlReciuit;
import com.sinister.entity.JlRecord;

public interface JlReciuitDao {

	/**
	 * 保存招聘信息
	 * @param jlReciuit
	 */
	public void JlSaveReciuit(JlReciuit jlReciuit);
	
	//根据公司账号密码的session查找公司信息的id
	public int jlFindComId(int c_id);
	//根据当前用户Session（uid）查找出简历投递的信息中的公司id
	//uid(用户基础表)==>u_mid(用户信息表)==>c_mid(投递表中的公司id)
	public void wait1();
	//根据当前的公司id在简历投递表中查找本公司的信息
	public List<JlRecord> findComRecord(int c_mid);
	
	
	
	
	
	
	
	
	
}
