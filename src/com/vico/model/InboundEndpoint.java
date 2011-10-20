package com.vico.model;

public class InboundEndpoint extends Endpoint {

	public InboundEndpoint(Interface interfce) {
		super(interfce);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InboundEndpoint [interface = ");
		builder.append(interfce);
		builder.append("]");
		return builder.toString();
	}

}
