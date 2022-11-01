package com.webservice.service.entite;


public class QuestionReqestService {
	
	private String qusCompany;
	private String ansCompany;
	private String serviceCode;
	private String serviceCondition;
	private String requestDatetime;
	
	
	
	public String getQusCompany() {
		return qusCompany;
	}
	public void setQusCompany(String qusCompany) {
		this.qusCompany = qusCompany;
	}
	public String getAnsCompany() {
		return ansCompany;
	}
	public void setAnsCompany(String ansCompany) {
		this.ansCompany = ansCompany;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getServiceCondition() {
		return serviceCondition;
	}
	public void setServiceCondition(String serviceCondition) {
		this.serviceCondition = serviceCondition;
	}
	public String getRequestDatetime() {
		return requestDatetime;
	}
	public void setRequestDatetime(String requestDatetime) {
		this.requestDatetime = requestDatetime;
	}

	@Override
	public String toString() {
		return "[qusCompany=" + qusCompany + ", ansCompany=" + ansCompany + ", ServiceCode="
				+ serviceCode + ", ServiceCondition=" + serviceCondition + ", RequestDatetime=" + requestDatetime + "]";
	}
	
	

}
