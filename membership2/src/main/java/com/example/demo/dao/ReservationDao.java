package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.ReservationManager;
import com.example.demo.vo.DepartmentVo;
import com.example.demo.vo.Doc_ScheduleVo;
import com.example.demo.vo.DoctorVo;

@Repository
public class ReservationDao {

	public List<DepartmentVo> findAllDept(){
		return ReservationManager.findAllDept();
	}
	
	public List<DoctorVo> findByNoDoc(HashMap map){
		return ReservationManager.findByNoDoc(map);
	}
	
	public List<Doc_ScheduleVo> findByNoSche(HashMap map){
		return ReservationManager.findByNoSche(map);
	}
	
}
