package com.sinister.service;

import java.util.List;

import com.sinister.entity.JlReciuit;
import com.sinister.entity.JlRecord;

public interface JlReciuitService {

	public void JlSaveReciuit(JlReciuit jlReciuit);

	// �����˺������session���ҹ�˾��Ϣ��id
	public int jlFindComId(int c_id);

	// ���ݵ�ǰ�Ĺ�˾id�ڼ���Ͷ�ݱ��в��ұ���˾����Ϣ
	public List<JlRecord> findComRecord(int c_cid);

	//���ݹ�˾session��id���ļ����¼�е�״̬�� ===> 1 �Ѳ鿴
		public void jlupdateStatusTo1(int c_cid);
		
		//���ݹ�˾session��id���ļ����¼�е�״̬�� ===> 2 ��Լ����
		public void jlupdateStatusTo2(int c_cid);
	
	
	
	
}
