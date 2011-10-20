package com.vico.model;

import java.util.ArrayList;
import java.util.List;

public class InfoSystem {
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	List<Service> services;
	//List<Interface> interfaces;
	
	public String toString(){
		String ret = "InfoSystem: "+name+"\r\n";
		ret = ret+"Services: \r\n";
		for (Service element : services) {
			ret = ret + element.toString();
		}
//		for (Interface element : interfaces) {
//			ret = ret + element.toString();
//		}
		return ret;
	}
	public void addService(Service serv){
		services.add(serv);
		serv.setSystem(this);
	}
	public InfoSystem(String name) {
		super();
		this.name = name;
		this.services = new ArrayList<Service>();
	}
	public Service getService(String service_name){
		for(Service s:services){
			if(s.name.equalsIgnoreCase(service_name)){
				return s;
			}
		}
		return null;
	}
	
}
