package com.sinister.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinister.dao.AkJobsDao;
import com.sinister.entity.AkModel;
import com.sinister.service.AkJobsService;
@Service
public class AkJobsServiceImpl implements AkJobsService {
	
	@Autowired
	private AkJobsDao akJobsDao;
	public List<AkModel> selectAkJobs() {
		return akJobsDao.selectAkJobs();
	}

	public List<AkModel> selectAkJobsFromName(String name) {
		return akJobsDao.selectAkJobsFromName(name);
	}

}
