package com.vico.model;

public class WSInterface extends Interface {
	String uri_wsdl;
	public String getUri_wsdl() {
		return uri_wsdl;
	}
	public void setUri_wsdl(String uri_wsdl) {
		this.uri_wsdl = uri_wsdl;
	}
	public WSInterface() {
		super();
		this.protocol = "HTTP";
	}
	public WSInterface(String uri){
		this();
		this.uri_wsdl = uri;
	}
}
