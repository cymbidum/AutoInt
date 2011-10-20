package com.vico.test;

import com.vico.model.*;

public class ProcessModelTest {
	public static void main(String[] args) {
		// create systems model
		SystemModel model=SystemModelTest.prepareSystemModel();
		ProcessModel flow = prepareProcessModel(model);

		System.out.println(flow);
	}
	public static ProcessModel prepareProcessModel(SystemModel model){
		ProcessModel flow = new ProcessModel("test");
		try {
			flow.setStart(model.getSystem("HIS").getService("Admission"));
			flow.addService(model.getSystem("HIS").getService("Fee"));
			flow.setEnd(model.getSystem("EMR").getService("Diagnosis"));
			flow.addService(model.getSystem("EMR").getService("Clinical"));
			flow.addService(model.getSystem("EMR").getService("Order"));
			flow.addService(model.getSystem("RIS").getService("Register"));
			flow.addService(model.getSystem("RIS").getService("Study"));
			flow.addService(model.getSystem("RIS").getService("Report"));
			flow.connect(model.getSystem("HIS").getService("Admission").getInterface("SendPatInfo"),model.getSystem("EMR").getService("Clinical").getInterface("AcceptPatInfo"));
			flow.connect(model.getSystem("EMR").getService("Order").getInterface("SendOrder"), model.getSystem("RIS").getService("Register").getInterface("AcceptOrder"));
			flow.connect(model.getSystem("EMR").getService("Order").getInterface("SendOrderFee"), model.getSystem("HIS").getService("Fee").getInterface("AcceptOrderFee"));
			flow.connect(model.getSystem("HIS").getService("Fee").getInterface("SendFeeStatus"), model.getSystem("RIS").getService("Register").getInterface("AcceptFeeStatus"));
			flow.connect(model.getSystem("RIS").getService("Study").getInterface("SendImage"), model.getSystem("EMR").getService("Diagnosis").getInterface("AcceptImage"));
			flow.connect(model.getSystem("RIS").getService("Report").getInterface("SendReport"), model.getSystem("EMR").getService("Diagnosis").getInterface("AcceptReport"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flow;
	}
}
