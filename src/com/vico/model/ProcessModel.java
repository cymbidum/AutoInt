package com.vico.model;

import java.util.ArrayList;
import java.util.List;

public class ProcessModel {
	public List<InfoSystem> getSystems() {
		return systems;
	}
	public void setSystems(List<InfoSystem> systems) {
		this.systems = systems;
	}
	public List<Service> getServices() {
		return services;
	}
	public void setServices(List<Service> services) {
		this.services = services;
	}
	String name;
	List<InfoSystem> systems;
	List<Service> services;
	List<Transaction> transactions;
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	Service start;
	Service end;
	public ProcessModel(String name) {
		super();
		this.name = name;
		systems = new ArrayList<InfoSystem>();
		services = new ArrayList<Service>();
		transactions = new ArrayList<Transaction>();
	}
	public void addService(Service s){
		if(!services.contains(s)){
			services.add(s);			
		}
		if(s.getSystem()!=null&&!(systems.contains(s.getSystem()))){
			systems.add(s.getSystem());
		}
	}
	public void connect(Interface from, Interface to) throws Exception{
		if(from.getService()==null||to.getService()==null){
			throw new Exception("service is null");
		}
		//check if the service is added
		if(!services.contains(from.getService())||!services.contains(to.getService())){
			throw new Exception("service not added");
		}
		//transaction is with different systems
		if(from.getService().getSystem().name.equalsIgnoreCase(to.getService().getSystem().name)){
			return;
		}
		Transaction trans = new Transaction();
		trans.setSrc(from);
		trans.setDest(to);
		trans.setName(from.name+"_"+to.name);
		transactions.add(trans);
	}
	public void setStart(Service s){
		start = s;
		addService(start);
	}
	public void setEnd(Service s){
		end = s;
		addService(end);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProcessModel [");
//		builder.append(systems);
		builder.append("services=\r\n");
		for(Service s:services){
			builder.append(s.name+" ");			
		}
		builder.append(",\r\n transactions=\r\n");
		builder.append(transactions);
//		builder.append(", toString()=");
//		builder.append(super.toString());
		builder.append("]\r\n");
		return builder.toString();
	}
	public boolean validate(){
		return true;
	}

	
}
