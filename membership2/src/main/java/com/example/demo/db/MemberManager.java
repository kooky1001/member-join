package com.example.demo.db;

import java.io.InputStream;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.MemberVo;

public class MemberManager {
	
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
	
	//회원가입
	public static int insert(MemberVo m) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.insert("member.insert", m);
		session.close();
		return re;
	}
	
	//비회원가입
	public static int insertGuest(MemberVo m) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.insert("member.insertGuest", m);
		session.close();
		return re;
	}
	
	//아이디 중복확인
	public static int checkId(HashMap map) {
		int n = -1;
		SqlSession session = sqlSessionFactory.openSession();
		n = session.selectOne("member.checkId", map);
		session.close();
		return n;
	}
	
	//주민번호 중복확인
	public static int checkRR(HashMap map) {
		int n = -1;
//		System.out.println(map);
		SqlSession session = sqlSessionFactory.openSession();
		n = session.selectOne("member.checkRR", map);
		session.close();
		return n;
	}
	
	//이름을 가져오기
	public static MemberVo getName(HashMap map) {
		MemberVo m = null;
		SqlSession session = sqlSessionFactory.openSession();
		m = session.selectOne("member.selectByRR", map);
		session.close();
		return m;
	}

}
