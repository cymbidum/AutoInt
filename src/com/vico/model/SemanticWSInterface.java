package com.vico.model;

import org.mindswap.owls.process.variable.Input;
import org.mindswap.owls.process.variable.Output;

public class SemanticWSInterface extends WSInterface {
	String owl_uri;
	ServiceSemantic semantic;
	public String getOwl_uri() {
		return owl_uri;
	}
	public void setOwl_uri(String owl_uri) {
		this.owl_uri = owl_uri;
	}
	public ServiceSemantic getServiceSemantic() {
		return semantic;
	}
	public void setServiceSemantic(ServiceSemantic semantic) {
		this.semantic = semantic;
	}
	public SemanticWSInterface(String owl_uri) {
		super();
		this.owl_uri = owl_uri;
		semantic = new ServiceSemantic(owl_uri);
		for(Input i:semantic.process.getInputs()){
			this.inputs.add(new Parameter(i.getName(),i.getParamType().toString()));
		}
		for(Output o:semantic.process.getOutputs()){
			this.outputs.add(new Parameter(o.getName(),o.getParamType().toString()));
		}
		this.wsdl_uri = semantic.getWSDL();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SemanticWSInterface [owl_uri=");
		builder.append(owl_uri);
//		builder.append(", semantic=");
//		builder.append(semantic);
		builder.append(", name=");
		builder.append(name);
		builder.append(", service=");
		builder.append(service==null?"null":service.name);
		builder.append(", protocol=");
		builder.append(protocol);
		builder.append(", inputs=");
		builder.append(inputs);
		builder.append(", outputs=");
		builder.append(outputs);
		builder.append(", wsdl=");
		builder.append(wsdl_uri);
		builder.append("]");
		return builder.toString();
	}

	
}
