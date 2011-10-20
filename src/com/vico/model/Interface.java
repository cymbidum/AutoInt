/**
 * 
 */
package com.vico.model;

/**
 * @author nhc
 *
 */
public class Interface {
	String name;
	String protocol;
	String semantic;//this can be a schema
	public String getSemantic() {
		return semantic;
	}
	public void setSemantic(String semantic) {
		this.semantic = semantic;
	}
	Service service;
	public Service getService() {
		return service;
	}
	public Interface(String name, String protocol) {
		super();
		this.name = name;
		this.protocol = protocol;
		semantic = "";
	}
	public void setService(Service s){
		this.service = s;
	}
	@Override
	public String toString() {
		return String.format(
				"Interface [name=%s, protocol=%s, service=%s]\r\n",
				name, protocol, service==null?"null":service.name);
	}
	
}
