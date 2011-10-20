package com.vico.model;

import java.util.List;

public class Topology {
	List<InfoSystem> systems;
	List<Transaction> transactions;
	public Topology(List<InfoSystem> systems, List<Transaction> transactions) {
		super();
		this.systems = systems;
		this.transactions = transactions;
	}
	public Topology(ProcessModel flow){
		this.systems = flow.getSystems();
		this.transactions = flow.getTransactions();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Topology \r\n[systems=");
		for (InfoSystem s : systems) {
			builder.append(s.getName()+" ");
		}
		builder.append("]\r\n");
//		builder.append(systems);
		builder.append(", transactions=");
//		builder.append(transactions);
		for(Transaction t:transactions){
			builder.append(t);
		}
		builder.append("]");
		return builder.toString();
	}
	
}
