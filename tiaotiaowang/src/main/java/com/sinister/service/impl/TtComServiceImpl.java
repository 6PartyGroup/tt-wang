package com.sinister.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinister.dao.TtComDao;
import com.sinister.entity.TtCom;
import com.sinister.service.TtComService;

@Service
public class TtComServiceImpl implements TtComService {

	@Autowired
	private TtComDao ttComDao;
	
	public List<TtCom> findTtCom(){
	
		return ttComDao.findTtCom();
		
	}
}
