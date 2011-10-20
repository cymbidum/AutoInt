package com.vico.model;

public class Endpoint extends Filter {
	Interface interfce;

	public Endpoint(Interface interfce) {
		super();
		this.interfce = interfce;
	}

	public Interface getInterface() {
		return interfce;
	}

	public void setInterface(Interface interfce) {
		this.interfce = interfce;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Endpoint [interfce=");
		builder.append(interfce);
//		builder.append(", toString()=");
//		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
	
}
