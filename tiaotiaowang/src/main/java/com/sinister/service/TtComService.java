package com.sinister.service;

import java.io.FileWriter;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.sinister.entity.TtCom;
import com.sinister.entity.TtComMessageEntity;

public interface TtComService {

	public List<TtCom> findTtCom();
	public void insertTtCom(TtCom ttCom);
	public TtComMessageEntity findcomMessage(TtComMessageEntity comMessageEntity);
	public void saveComMessage(TtComMessageEntity comMessageEntity);
}
