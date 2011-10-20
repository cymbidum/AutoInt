package com.vico.model;

public class Filter {
	String name;
	Filter previous;
	Filter next;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Filter getPrevious() {
		return previous;
	}
	public void setPrevious(Filter previous) {
		this.previous = previous;
	}
	public Filter getNext() {
		return next;
	}
	public void setNext(Filter next) {
		this.next = next;
	}
	
	
}
