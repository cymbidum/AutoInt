package com.vico.model;
import java.io.IOException;
import java.net.URI;

import org.mindswap.owls.process.AtomicProcess;
import org.mindswap.owls.process.Process;
import org.mindswap.owls.profile.Profile;
import org.mindswap.owls.service.Service;
import org.mindswap.owl.OWLFactory;
import org.mindswap.owl.OWLKnowledgeBase;
import org.mindswap.owl.OWLOntology;
import org.mindswap.owls.grounding.AtomicGrounding;
import org.mindswap.owls.grounding.Grounding;

public class ServiceSemantic {
	OWLOntology ontology;
	Service service;
	Process process;
	Profile profile;
	AtomicGrounding grounding;
	OWLKnowledgeBase kb;
	ServiceSemantic(String uri_owl){
		kb = OWLFactory.createKB();
		URI uri = URI.create(uri_owl);
		try {
			ontology = kb.read(uri);
			service = kb.readService(uri);
			profile = service.getProfile();
			process = service.getProcess();
			if(process instanceof AtomicProcess){
				grounding = ((AtomicProcess)process).getGrounding();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceSemantic [ontology=");
		builder.append(ontology);
		builder.append(", service=");
		builder.append(service);
		builder.append(", process=");
		builder.append(process);
		builder.append(", profile=");
		builder.append(profile);
		builder.append(", grounding=");
		builder.append(grounding);
		builder.append("]\r\n");
		return builder.toString();
	}
	public String getWSDL(){
		if(grounding!=null){
			return grounding.getDescriptionURL().toString();
		}
		return "";
	}
	
}
