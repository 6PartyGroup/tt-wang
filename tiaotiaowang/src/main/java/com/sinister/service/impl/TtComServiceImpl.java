package com.sinister.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinister.dao.TtComDao;
import com.sinister.entity.TtCom;
import com.sinister.entity.TtComMessageEntity;
import com.sinister.service.TtComService;

@Service
public class TtComServiceImpl implements TtComService {

	@Autowired
	private TtComDao ttComDao;
	
	public List<TtCom> findTtCom(){
	
		return ttComDao.findTtCom();
		
	}
	
	public void insertTtCom(TtCom ttCom){
		ttComDao.insertTtCom(ttCom);
	}
	public TtComMessageEntity findcomMessage(TtComMessageEntity comMessageEntity){
		return ttComDao.findcomMessage(comMessageEntity);
	}

	public void saveComMessage(TtComMessageEntity comMessageEntity) {
		ttComDao.saveComMessage(comMessageEntity);
		
	}
}
