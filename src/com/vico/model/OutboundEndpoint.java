package com.vico.model;

public class OutboundEndpoint extends Endpoint {

	public OutboundEndpoint(Interface interfce) {
		super(interfce);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OutboundEndpoint [interface = ");
		builder.append(interfce);
		builder.append("]");
		return builder.toString();
	}
}
