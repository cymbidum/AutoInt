package com.vico.model;

public class Transformer extends Filter {
	String name;
	String method;
	String type;//script, xslt, service, java class
	String src;
	String dest;
	public String transform(String input){
		//do transform here
		return "";
	}
	static Transformer getTransformer(String src, String dest){
		Transformer tfr = new Transformer();
		tfr.name = "new transformer";
		tfr.src =src;
		tfr.dest = dest;
		tfr.type = Util.TRANSFORMER_XSLT;
		tfr.method = "";
		return tfr;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transformer [name=");
		builder.append(name);
		builder.append(", method=");
		builder.append(method);
		builder.append(", type=");
		builder.append(type);
		builder.append("]\r\n");
		return builder.toString();
	}
	
}


