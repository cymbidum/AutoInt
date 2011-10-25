package com.vico.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Connection {
	String name;
	Transaction trans;
	ArrayList<Filter> pipe;

	public Connection(Transaction trans) {
		super();
		this.trans = trans;
		this.name = "conn_" + trans.getName();
		this.pipe = new ArrayList<Filter>();
		pipe.add(new InboundEndpoint(trans.src));
		pipe.add(new OutboundEndpoint(trans.dest));
		generate();
	}
	public void generate(){
		
		Adapter inbound_adapter = null;
		Adapter outbound_adapter = null;
		//generate inbound adapter
		inbound_adapter = findAdapter(getInboundEndpoint());
		getInboundEndpoint().setNext(inbound_adapter);
		inbound_adapter.setPrevious(getInboundEndpoint());
		inbound_adapter.setNext(getOutboundEndpoint());
		pipe.add(inbound_adapter);
		//generate outbound adapter
		outbound_adapter = findAdapter(getOutboundEndpoint());
		outbound_adapter.setPrevious(inbound_adapter);
		outbound_adapter.setNext(getOutboundEndpoint());
		getOutboundEndpoint().setPrevious(outbound_adapter);
		pipe.add(outbound_adapter);
		//generate transformer
		if(inbound_adapter!=null&&outbound_adapter!=null){	
			Transformer transf = findTransformer(getInboundEndpoint().getInterface().getSemantic(),getOutboundEndpoint().getInterface().getSemantic());	
			transf.setPrevious(inbound_adapter);
			transf.setNext(outbound_adapter);
			outbound_adapter.setPrevious(transf);
			inbound_adapter.setNext(transf);
			pipe.add(transf);
		}

	}
	private Adapter findAdapter(Endpoint e){
		//search for adapter
		return Adapter.findAdapter(e);
	}
	private Transformer findTransformer(String src,String dest){
		//generate transformer
		return Transformer.getTransformer(src, dest);
	}
	private InboundEndpoint getInboundEndpoint(){
		for(Filter f:pipe){
			if (f instanceof InboundEndpoint){
				return (InboundEndpoint)f; //only one inbound endpoint in a pipe
			}
		}
		return null;
	}
	private OutboundEndpoint getOutboundEndpoint(){
		for(Filter f:pipe){
			if (f instanceof OutboundEndpoint){
				return (OutboundEndpoint)f; //return the first found. to be improved
			}
		}
		return null;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Connection [name=");
		builder.append(name);
		builder.append(", \r\ntrans=");
		builder.append(trans);
		builder.append(", pipe=\r\n");
		Filter cur = getInboundEndpoint();
		int i=0;
		while(cur != null){
			builder.append(++i);
			builder.append(":");
			builder.append(cur);
			cur = cur.getNext();
		}

//		builder.append(pipe);
		builder.append("]");
		return builder.toString();
	}
	
	
}
