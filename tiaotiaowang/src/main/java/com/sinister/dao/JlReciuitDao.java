package com.sinister.dao;

import java.util.List;

import com.sinister.entity.JlReciuit;
import com.sinister.entity.JlRecord;

public interface JlReciuitDao {

	/**
	 * ������Ƹ��Ϣ
	 * @param jlReciuit
	 */
	public void JlSaveReciuit(JlReciuit jlReciuit);
	
	//���ݹ�˾�˺������session���ҹ�˾��Ϣ��id
	public int jlFindComId(int c_id);
	//���ݵ�ǰ�û�Session��uid�����ҳ�����Ͷ�ݵ���Ϣ�еĹ�˾id
	//uid(�û�������)==>u_mid(�û���Ϣ��)==>c_mid(Ͷ�ݱ��еĹ�˾id)
	public void wait1();
	//���ݵ�ǰ�Ĺ�˾id�ڼ���Ͷ�ݱ��в��ұ���˾����Ϣ
	public List<JlRecord> findComRecord(int c_cid);
	
	//���ݹ�˾session��id���ļ����¼�е�״̬�� ===> 1 �Ѳ鿴
	public void jlupdateStatusTo1(int c_cid);
	
	//���ݹ�˾session��id���ļ����¼�е�״̬�� ===> 2 ��Լ����
	public void jlupdateStatusTo2(int c_cid);
	
	
	
	
	
}
