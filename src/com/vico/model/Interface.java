/**
 * 
 */
package com.vico.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nhc
 *
 */
public class Interface {
	String name;
	Service service;
	String protocol;
	String semantic;//this can be a schema
	Message message;
	List<Parameter> inputs;
	List<Parameter> outputs;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public List<Parameter> getInputs() {
		return inputs;
	}
	public void setInputs(List<Parameter> inputs) {
		this.inputs = inputs;
	}
	public List<Parameter> getOutputs() {
		return outputs;
	}
	public void setOutputs(List<Parameter> outputs) {
		this.outputs = outputs;
	}
	
	public static SemanticWSInterface loadSemanticWS(String owl_uri){
		SemanticWSInterface ice = new SemanticWSInterface(owl_uri);
		return ice;
	}

	
	public Interface() {
		super();
		this.service = null;
		this.inputs = new ArrayList<Parameter>();
		this.outputs = new ArrayList<Parameter>();
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public String getSemantic() {
		return semantic;
	}
	public void setSemantic(String semantic) {
		this.semantic = semantic;
	}

	public Service getService() {
		return service;
	}
	public Interface(String name, String protocol) {
		this();
		this.name = name;
		this.protocol = protocol;
		semantic = "";
	}
	public void setService(Service s){
		this.service = s;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Interface [name=");
		builder.append(name);
		builder.append(", service=");
		builder.append(service==null?"null":service.name);
		builder.append(", protocol=");
		builder.append(protocol);
		builder.append(", semantic=");
		builder.append(semantic);
		builder.append(", message=");
		builder.append(message);
		builder.append(", inputs=");
		builder.append(inputs);
		builder.append(", outputs=");
		builder.append(outputs);
		builder.append("]");
		return builder.toString();
	}
	
}
