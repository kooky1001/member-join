package com.example.demo.sms;

public class ServiceSMSSoapProxy implements com.example.demo.sms.ServiceSMSSoap {
  private String _endpoint = null;
  private com.example.demo.sms.ServiceSMSSoap serviceSMSSoap = null;
  
  public ServiceSMSSoapProxy() {
    _initServiceSMSSoapProxy();
  }
  
  public ServiceSMSSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceSMSSoapProxy();
  }
  
  private void _initServiceSMSSoapProxy() {
    try {
      serviceSMSSoap = (new com.example.demo.sms.ServiceSMSLocator()).getServiceSMSSoap();
      if (serviceSMSSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviceSMSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviceSMSSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviceSMSSoap != null)
      ((javax.xml.rpc.Stub)serviceSMSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.example.demo.sms.ServiceSMSSoap getServiceSMSSoap() {
    if (serviceSMSSoap == null)
      _initServiceSMSSoapProxy();
    return serviceSMSSoap;
  }
  
  public java.lang.String sendSMS(java.lang.String smsID, java.lang.String hashValue, java.lang.String senderPhone, java.lang.String receivePhone, java.lang.String smsContent) throws java.rmi.RemoteException{
    if (serviceSMSSoap == null)
      _initServiceSMSSoapProxy();
    return serviceSMSSoap.sendSMS(smsID, hashValue, senderPhone, receivePhone, smsContent);
  }
  
  public java.lang.String sendSMSwnc(java.lang.String smsID, java.lang.String hashValue, java.lang.String gubun, java.lang.String senderPhone, java.lang.String receivePhone, java.lang.String smsContent) throws java.rmi.RemoteException{
    if (serviceSMSSoap == null)
      _initServiceSMSSoapProxy();
    return serviceSMSSoap.sendSMSwnc(smsID, hashValue, gubun, senderPhone, receivePhone, smsContent);
  }
  
  public java.lang.String sendSMSReserve(java.lang.String smsID, java.lang.String hashValue, java.lang.String senderPhone, java.lang.String receivePhone, java.lang.String smsContent, java.lang.String reserveDate, java.lang.String reserveTime, java.lang.String userDefine) throws java.rmi.RemoteException{
    if (serviceSMSSoap == null)
      _initServiceSMSSoapProxy();
    return serviceSMSSoap.sendSMSReserve(smsID, hashValue, senderPhone, receivePhone, smsContent, reserveDate, reserveTime, userDefine);
  }
  
  public java.lang.String sendSMSCallBack(java.lang.String smsID, java.lang.String hashValue, java.lang.String senderPhone, java.lang.String receivePhone, java.lang.String callbackUrl, java.lang.String smsContent) throws java.rmi.RemoteException{
    if (serviceSMSSoap == null)
      _initServiceSMSSoapProxy();
    return serviceSMSSoap.sendSMSCallBack(smsID, hashValue, senderPhone, receivePhone, callbackUrl, smsContent);
  }
  
  public java.lang.String sendSMSCallBackReserve(java.lang.String smsID, java.lang.String hashValue, java.lang.String senderPhone, java.lang.String receivePhone, java.lang.String callbackUrl, java.lang.String smsContent, java.lang.String reserveDate, java.lang.String reserveTime, java.lang.String userDefine) throws java.rmi.RemoteException{
    if (serviceSMSSoap == null)
      _initServiceSMSSoapProxy();
    return serviceSMSSoap.sendSMSCallBackReserve(smsID, hashValue, senderPhone, receivePhone, callbackUrl, smsContent, reserveDate, reserveTime, userDefine);
  }
  
  public int reserveCancle(java.lang.String smsID, java.lang.String hashValue, java.lang.String searchValue, java.lang.String mode) throws java.rmi.RemoteException{
    if (serviceSMSSoap == null)
      _initServiceSMSSoapProxy();
    return serviceSMSSoap.reserveCancle(smsID, hashValue, searchValue, mode);
  }
  
  public int getRemainCount(java.lang.String smsID, java.lang.String hashValue) throws java.rmi.RemoteException{
    if (serviceSMSSoap == null)
      _initServiceSMSSoapProxy();
    return serviceSMSSoap.getRemainCount(smsID, hashValue);
  }
  
  
}