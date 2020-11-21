package com.example.demo.controller;

import java.util.HashMap;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MemberDao;
import com.example.demo.sms.BitSms;
import com.example.demo.util.CheckRR;
import com.example.demo.vo.MemberVo;

@Controller
public class MemberController {

	@Autowired
	private MemberDao dao;
	
	//회원가입 페이지로 보내기
	@GetMapping("/insertMember")
	public ModelAndView insertForm() {
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	
	//회원등록을 위한 메소드
	@PostMapping("/insertMember")
	public ModelAndView insertSubmit(MemberVo m) {
		ModelAndView mav = new ModelAndView("/joinOk");
		int re = dao.insert(m);
		mav.addObject("m", m);
		mav.addObject("re", re);
		mav.addObject("msg", "회원");
		return mav;
	}
	
	//회원등록을 위한 메소드
	@PostMapping("/insertGuest")
	public ModelAndView insertGuest(MemberVo m) {
		ModelAndView mav = new ModelAndView("/joinOk");
		int re = dao.insert(m);
		mav.addObject("m", m);
		mav.addObject("re", re);
		mav.addObject("msg", "비회원");
		return mav;
	}
	
	//회원 아이디 중복확인
	@PostMapping("/checkId")
	@ResponseBody
	public String checkId(@RequestParam HashMap map) {
		int n = dao.checkId(map);
		return n+"";
	}
	
	//본인인증폼
	@GetMapping("/checkMember")
	public void checkForm() {
		
	}
	
	@PostMapping("/checkMember")
	public ModelAndView checkMember(MemberVo m) {
		ModelAndView mav = new ModelAndView("/insertMember");
		mav.addObject("m", m);
		return mav;
	}
	
	@PostMapping("/checkRR")
	@ResponseBody
	public HashMap checkRR(@RequestParam HashMap map) {
		System.out.println(map);
		map.put("roles", "USER");
		String rr_check = (String)map.get("rr_check");
		int already = dao.checkRR(map);
		
		String re = CheckRR.check(rr_check);
		HashMap data = new HashMap<>();
		data.put("already",	already);
		data.put("re", re);
		return data;
	}
	
	@PostMapping("/checkTel")
	@ResponseBody
	public HashMap checkTel(@RequestParam HashMap map) {
		String to = (String)map.get("tel");
		Random r = new Random();
		String msg  =  r.nextInt(10) +""+r.nextInt(10)+""+r.nextInt(10)+""+r.nextInt(10)+""+r.nextInt(10)+""+r.nextInt(10);
		System.out.println(msg);
		String send = BitSms.sendMsg(to, msg);
		HashMap data = new HashMap<>();
		data.put("send", send);
		data.put("msg", msg);
		return data;
	}
	
	@GetMapping("/checkGuest")
	public void guestForm() {}
	
	@PostMapping("/checkGuest")
	public ModelAndView guestSubmit(MemberVo m) {
		ModelAndView mav = new ModelAndView("/joinOk");
		mav.addObject("m", m);
		return mav;
	}
	
	@PostMapping("/guestRR")
	@ResponseBody
	public HashMap guestRR(@RequestParam HashMap map) {
		map.put("roles", "GUEST");
		String rr_check = (String)map.get("rr_check");
		int already = dao.checkRR(map);
		
//		System.out.println(already);
		
		String re = CheckRR.check(rr_check);
		MemberVo mem = dao.getName(map);
		System.out.println(mem);
		
		HashMap data = new HashMap<>();
		data.put("already",	already);
		data.put("re", re);
		data.put("mem", mem);
		return data;
	}
	
	
	
	
	
	
	
	
	@GetMapping("/list")
	public void list() {
	}
	@GetMapping("/test")
	public void test(String ir1) {
		System.out.println(ir1);
	}
	@GetMapping("/join-allow")
	public void join() {
	}
	@GetMapping("/joinOk")
	public void joinOk() {
	}
}
