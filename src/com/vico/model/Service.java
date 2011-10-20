package com.vico.model;

import java.util.ArrayList;
import java.util.List;

public class Service {
	String name;
	List<Interface> interfaces = null;
	InfoSystem system;
	public InfoSystem getSystem() {
		return system;
	}
	public void setSystem(InfoSystem system) {
		this.system = system;
	}
	public void addInterface(Interface i){
		interfaces.add(i);
		i.setService(this);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Service ");
		builder.append("name=");
		builder.append(name);
		builder.append("\r\n");
		builder.append("interfaces=\r\n");
		for (Interface i : interfaces) {
			builder.append(i.toString());
		}
		return builder.toString();
	}
	public Service(String name) {
		super();
		this.name = name;
		this.interfaces = new ArrayList<Interface>();
	}
	public Interface getInterface(String name){
		for(Interface i: interfaces){
			if(i.name.equalsIgnoreCase(name)){
				return i;
			}
		}
		return null;
	}
	

	
}
