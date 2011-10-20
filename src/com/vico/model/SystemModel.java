package com.vico.model;

import java.util.ArrayList;
import java.util.List;

public class SystemModel {
	String name="SystemModel";
	List<InfoSystem> systems;
	public void addSystem(InfoSystem s){
		systems.add(s);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemModel: "+name+" [\r\n");
		for(InfoSystem s:systems){
			builder.append(s.toString());
		}
//		builder.append("]\r\n");
		return builder.toString();
	}
	public SystemModel(String name) {
		super();
		this.name = name;
		this.systems = new ArrayList<InfoSystem>();
	}
	public InfoSystem getSystem(String name){
		for(InfoSystem s:systems){
			if(s.getName().equalsIgnoreCase(name)){
				return s;
			}
		}
		return null;
	}
	
}
