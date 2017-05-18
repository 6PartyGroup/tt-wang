package com.sinister.dao;

import java.util.List;

import com.sinister.entity.TtCom;
import com.sinister.entity.TtComMessageEntity;

public interface TtComDao {

	public List<TtCom> findTtCom();
	public void insertTtCom(TtCom ttCom);
	public TtComMessageEntity findcomMessage(TtComMessageEntity comMessageEntity);
	public void saveComMessage(TtComMessageEntity comMessageEntity);
	public TtCom findComName(TtCom ttCom);
	public TtComMessageEntity findcomMessage_name(TtComMessageEntity comMessageEntity);
	public void saveComMessagefile(TtComMessageEntity cME);
	public TtComMessageEntity findcomMessage_logo(TtComMessageEntity cME);

}
