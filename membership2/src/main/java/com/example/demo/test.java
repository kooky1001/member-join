package com.example.demo;

import com.example.demo.sms.BitSms;

public class test {

	public static void main(String[] args) {
		String re = BitSms.sendMsg("01040290290", "test");
		System.out.println(re);
	}
}
