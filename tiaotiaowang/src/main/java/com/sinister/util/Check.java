package com.sinister.util;

import org.springframework.stereotype.Component;

@Component
public class Check {

	//验证用户名必须是英文开头并且是5-10位的
	public	boolean checkC_comName(String C_comName){
		String comName="^[A-Za-z][A-Za-z0-9_-]{5,10}+$";
		if(C_comName.matches(comName)){
			return true;
		}
		return false;
	}
	//验证公司名称是中文开头只能包括中文英文和数字的
	public	boolean checkc_name(String c_name){
		String Messagename="^[\u0391-\uFFE5]+$";
		if(c_name.matches(Messagename)){
			return true;
		}
		return false;
	}
	//验证公司电话的
	public	boolean checkc_telon(String c_telon){
		String telon="^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
		if(c_telon.matches(telon)){
			return true;
		}
		return false;
	}
	//验证公司性质的(中文)
		public	boolean checkc_nature(String c_nature){
			String nature="^[\u4e00-\u9fa5]{0,}$";
			if(c_nature.matches(nature)){
				return true;
			}
			return false;
		}
	
}
