package com.sinister.service;

import java.util.List;

import com.sinister.entity.AkModel;

public interface AkJobsService {
	public List<AkModel> selectAkJobs();
	public List<AkModel> selectAkJobsFromName(String name);
}
