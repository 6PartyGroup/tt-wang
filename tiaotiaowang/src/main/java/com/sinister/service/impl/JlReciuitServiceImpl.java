package com.sinister.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinister.dao.JlReciuitDao;
import com.sinister.entity.JlReciuit;
import com.sinister.entity.JlRecord;
import com.sinister.service.JlReciuitService;

@Service
public class JlReciuitServiceImpl implements JlReciuitService{

	@Autowired
	private JlReciuitDao jlReciuitDao ;
	

	public void JlSaveReciuit(JlReciuit jlReciuit) {
		jlReciuitDao.JlSaveReciuit(jlReciuit);
	}

	public int jlFindComId(int c_id) {
		return jlReciuitDao.jlFindComId(c_id);
	}

	public List<JlRecord> findComRecord(int c_cid) {	
		return jlReciuitDao.findComRecord(c_cid);
	}

	public void jlupdateStatusTo1(int c_cid) {
	}

	public void jlupdateStatusTo2(int c_cid) {
		
	}

	
	
	
	
	
	
	
}