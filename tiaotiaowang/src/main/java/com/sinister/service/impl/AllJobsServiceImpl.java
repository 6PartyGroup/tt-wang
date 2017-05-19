package com.sinister.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinister.dao.AllJobsDao;
import com.sinister.entity.AllJobs;
import com.sinister.service.AllJobsService;

@Service
public class AllJobsServiceImpl implements AllJobsService {

	@Autowired
	private AllJobsDao allJobsDao;
	
	
	public List<AllJobs> get(){
		return allJobsDao.selectAllJobs();
	}



}
