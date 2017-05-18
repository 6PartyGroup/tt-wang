package com.sinister.dao;

import java.util.List;

import com.sinister.entity.AkModel;

public interface AkJobsDao {
	public List<AkModel> selectAkJobs();
	public List<AkModel> selectAkJobsFromName(String name);
	
}
