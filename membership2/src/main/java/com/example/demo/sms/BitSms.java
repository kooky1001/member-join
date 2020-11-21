package com.example.demo.sms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.example.demo.sms.ServiceSMSSoapProxy;

public class BitSms {
	public static String sendMsg(String to, String msg) {
		String send = "";
		String smsID = "rola";
		String smsPW = "bit123400";

		ServiceSMSSoapProxy sendsms = new ServiceSMSSoapProxy();
		try {
			String senderPhone = "01025598279";
			String receivePhone = to;
			String smsContent = "본인확인 인증번호 [" + msg + "] 입니다. '타인 노출 금지'";
			String test1 = (smsID + smsPW + receivePhone);
			CEncrypt encrypt = new CEncrypt("MD5", test1);
			send = sendsms.sendSMS(smsID, encrypt.getEncryptData(), senderPhone, receivePhone, smsContent);
			System.out.println("결과코드:" + send);

		} catch (Exception e) {
			System.out.println("Exception in main:" + e);
		}

		return send;
	}
}
