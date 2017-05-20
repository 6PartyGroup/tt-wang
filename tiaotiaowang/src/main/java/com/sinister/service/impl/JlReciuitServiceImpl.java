package com.sinister.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinister.dao.AllJobsDao;
import com.sinister.dao.JlReciuitDao;
import com.sinister.dao.UserMessageDao;
import com.sinister.entity.AllJobs;
import com.sinister.entity.JlReciuit;
import com.sinister.entity.JlRecord;
import com.sinister.entity.UserMessage;
import com.sinister.service.JlReciuitService;

@Service
public class JlReciuitServiceImpl implements JlReciuitService {

	@Autowired
	private JlReciuitDao jlReciuitDao;
	@Autowired
	private AllJobsDao allJobsDao;
	@Autowired
	private UserMessageDao userMessageDao ;

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

	public List<AllJobs> JlFindJobs() {
		return allJobsDao.JlFindJobs();
	}

	public List<AllJobs> JlfindSmallJob(int a_id) {
		return allJobsDao.JlfindSmallJob(a_id);
	}

	public List<UserMessage> jlSeePeople(int u_mid){
		
		return userMessageDao.jlSeePeople(u_mid);
	};//UserMessageDao

}