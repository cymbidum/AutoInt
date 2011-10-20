package com.vico.model;

public class Transaction {
	String name="";
	InfoSystem from;
	InfoSystem to;
	Interface src;
	Interface dest;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public InfoSystem getFrom() {
		return from;
	}
	public void setFrom(InfoSystem from) {
		this.from = from;
	}
	public InfoSystem getTo() {
		return to;
	}
	public void setTo(InfoSystem to) {
		this.to = to;
	}
	public Interface getSrc() {
		return src;
	}
	public void setSrc(Interface src) {
		this.src = src;
	}
	public Interface getDest() {
		return dest;
	}
	public void setDest(Interface dest) {
		this.dest = dest;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transaction [src=");
		builder.append(src);
		builder.append(", dest=");
		builder.append(dest);
		builder.append("]\r\n");
		return builder.toString();
	}
	
}
