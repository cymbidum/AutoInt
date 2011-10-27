package com.vico.model;

public class WSInterface extends Interface {
	String wsdl_uri;
	public String getUri_wsdl() {
		return wsdl_uri;
	}
	public void setUri_wsdl(String uri_wsdl) {
		this.wsdl_uri = uri_wsdl;
	}
	public WSInterface() {
		super();
		this.protocol = "HTTP";
	}
	public WSInterface(String uri){
		this();
		this.wsdl_uri = uri;
	}
}
