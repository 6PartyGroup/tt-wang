package com.sinister.service;

import java.util.List;

import com.sinister.entity.JlReciuit;
import com.sinister.entity.JlRecord;

public interface JlReciuitService {

	public void JlSaveReciuit(JlReciuit jlReciuit);

	// 根据账号密码的session查找公司信息的id
	public int jlFindComId(int c_id);

	// 根据当前的公司id在简历投递表中查找本公司的信息
	public List<JlRecord> findComRecord(int c_mid);

	
	
	
	
	
}
