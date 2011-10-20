package com.vico.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Connection {
	String name;
	Transaction trans;
	LinkedList<Filter> pipe;

	public Connection(Transaction trans) {
		super();
		this.trans = trans;
		this.name = "conn_" + trans.getName();
		this.pipe = new LinkedList<Filter>();
		pipe.addFirst(new InboundEndpoint(trans.src));
		pipe.addLast(new OutboundEndpoint(trans.dest));
		generate();
	}
	public void generate(){
		ListIterator<Filter> iter = pipe.listIterator();
		Adapter inbound_adapter = null;
		Adapter outbound_adapter = null;
		while(iter.hasNext()){
			Filter f = iter.next();
			if(f instanceof InboundEndpoint){
				inbound_adapter = findAdapter((Endpoint)f);
				iter.add(inbound_adapter);
				}
			if(f instanceof OutboundEndpoint){
				iter.previous();
				outbound_adapter = findAdapter((Endpoint)f);
				if(inbound_adapter!=null&&outbound_adapter!=null){	
					iter.add(findTransformer(getInboundEndpoint().getInterface().getSemantic(),getOutboundEndpoint().getInterface().getSemantic()));
				}
				iter.add(outbound_adapter);
				break;
			}
//			if(f instanceof Adapter){
//				Adapter dest = iter.next();
//				if(iter.next() instanceof Endpoint){
//					iter.add(e);
//					break;
//				}
//			}
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
		return (InboundEndpoint)pipe.getFirst();
	}
	private OutboundEndpoint getOutboundEndpoint(){
		return (OutboundEndpoint)pipe.getLast();
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Connection [name=");
		builder.append(name);
		builder.append(", \r\ntrans=");
		builder.append(trans);
		builder.append(", pipe=\r\n");
		Iterator<Filter> iter = pipe.iterator();
		int i=0;
		while(iter.hasNext()){
			builder.append(++i);
			builder.append(":");
			builder.append(iter.next());
		}
//		builder.append(pipe);
		builder.append("]");
		return builder.toString();
	}
	
	
}
