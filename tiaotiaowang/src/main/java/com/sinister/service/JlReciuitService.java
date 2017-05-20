package com.sinister.service;

import java.util.List;

import com.sinister.entity.AllJobs;
import com.sinister.entity.JlReciuit;
import com.sinister.entity.JlRecord;

public interface JlReciuitService {

	public void JlSaveReciuit(JlReciuit jlReciuit);

	// 根据账号密码的session查找公司信息的id
	public int jlFindComId(int c_id);

	// 根据当前的公司id在简历投递表中查找本公司的信息
	public List<JlRecord> findComRecord(int c_cid);

	// 根据公司session中id更改监理记录中的状态码 ===> 1 已查看
	public void jlupdateStatusTo1(int r_rid);

	// 根据公司session中id更改监理记录中的状态码 ===> 2 邀约面试
	public void jlupdateStatusTo2(int r_rid);

	// 查找工作中的大分类
	public List<AllJobs> JlFindJobs();

	public List<AllJobs> JlfindSmallJob(int a_id);

}
