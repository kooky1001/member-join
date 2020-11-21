package com.example.demo.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.DepartmentVo;
import com.example.demo.vo.Doc_ScheduleVo;
import com.example.demo.vo.DoctorVo;

public class ReservationManager {

	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "com/example/demo/db/sqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory =
			  new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("manager:"+e.getMessage());
		}
	}
	
	//부서목록 불러오기
	public static List<DepartmentVo> findAllDept() {
		List<DepartmentVo> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("res.selectAllDept");
		session.close();
		return list;
	}
	
	//의료진 목록 불러오기
	public static List<DoctorVo> findByNoDoc(HashMap map) {
		List<DoctorVo> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("res.selectByNoDoc", map);
		session.close();
		return list;
	}
	
	//의료진 스케쥴 불러오기
	public static List<Doc_ScheduleVo> findByNoSche(HashMap map) {
		List<Doc_ScheduleVo> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("res.selectByNoSche", map);
		session.close();
		return list;
	}
}
