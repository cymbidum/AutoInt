package com.vico.model;

import java.util.HashMap;

public class Adapter extends Filter {
	static HashMap<String,Adapter> adapters = new HashMap<String,Adapter>();
//	Endpoint _p;
	String name;
	String protocol;
	
	public Adapter(String name, String protocol) {
		super();
		this.name = name;
		this.protocol = protocol;
	}
	static Adapter findAdapter(Endpoint e){
		prepareAdapters();
		Adapter ret = null;
		if(e!=null){
			ret = adapters.get(e.interfce.protocol);
		}
		if(ret==null){
			ret = new Adapter("EmptyAdapter",e.interfce.protocol);
		}
		return ret;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Adapter [name=");
		builder.append(name);
		builder.append(", protocol=");
		builder.append(protocol);
		builder.append("]\r\n");
		return builder.toString();
	}
	static void prepareAdapters(){
		adapters.put(Util.PROTOCOL_DATABASE, new Adapter("db_adapter",Util.PROTOCOL_DATABASE));
		adapters.put(Util.PROTOCOL_DICOM, new Adapter("dcm_adapter",Util.PROTOCOL_DICOM));
		adapters.put(Util.PROTOCOL_HL7, new Adapter("hl7_adapter",Util.PROTOCOL_HL7));
		adapters.put(Util.PROTOCOL_FILE, new Adapter("file_adapter",Util.PROTOCOL_FILE));
	}
	
}
