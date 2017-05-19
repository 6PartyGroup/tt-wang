package com.sinister.dao;

import java.util.List;

import com.sinister.entity.AllJobs;

public interface AllJobsDao {
	//haha
	public List<AllJobs> selectAllJobs();
	
	//90 add method
	public List<AllJobs> JlFindJobs();
	
	public List<AllJobs> JlfindSmallJob(int a_id);
	
}
