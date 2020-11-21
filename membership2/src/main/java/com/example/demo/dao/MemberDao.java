package com.example.demo.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.example.demo.db.MemberManager;
import com.example.demo.vo.MemberVo;

@Repository
public class MemberDao {

	public int insert(MemberVo m) {
		return MemberManager.insert(m);
	}
	
	public int insertGuest(MemberVo m) {
		return MemberManager.insertGuest(m);
	}
	
	public int checkId(HashMap map) {
		return MemberManager.checkId(map);
	}
	
	public int checkRR(HashMap map) {
		return MemberManager.checkRR(map);
	}
	
	public MemberVo getName(HashMap map) {
		return MemberManager.getName(map);
	}
	
	
}
