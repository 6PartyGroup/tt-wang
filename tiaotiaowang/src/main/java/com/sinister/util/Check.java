package com.sinister.util;

import org.springframework.stereotype.Component;

@Component
public class Check {

	public	boolean checkC_comName(String C_comName){
		String comName="^[A-Za-z][A-Za-z0-9_-]{5,10}+$";
		if(C_comName.matches(comName)){
			return true;
		}
		return false;
	}
}
