package com.vico.test;


import com.vico.model.Interface;
import com.vico.model.Service;
import com.vico.model.InfoSystem;
import com.vico.model.SystemModel;
import com.vico.model.Util;

public class SystemModelTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(prepareSystemModel().toString());
	}
	public static SystemModel prepareSystemModel(){
		// create systems model
		SystemModel model=new SystemModel("test");
		//HIS
		InfoSystem sysHIS=new InfoSystem("HIS");
		//admission service
		Service serAdmission = new Service("Admission");
		Interface intSendPatInfo = new Interface("SendPatInfo",Util.PROTOCOL_DATABASE);
		serAdmission.addInterface(intSendPatInfo);
		sysHIS.addService(serAdmission);
		//fee service
		Service serFee = new Service("Fee");
		Interface intSendFeeStatus = new Interface("SendFeeStatus",Util.PROTOCOL_DATABASE);
		serFee.addInterface(intSendFeeStatus);
		Interface intAcceptOrderFee = new Interface("AcceptOrderFee",Util.PROTOCOL_DATABASE);
		serFee.addInterface(intAcceptOrderFee);
		sysHIS.addService(serFee);
		//add HIS
		model.addSystem(sysHIS);
		
		//EMR
		InfoSystem sysEMR=new InfoSystem("EMR");
		//Diagnosis service
		Service serClinical = new Service("Clinical");
		Interface intAcceptPatInfo = new Interface("AcceptPatInfo",Util.PROTOCOL_HL7);
		serClinical.addInterface(intAcceptPatInfo);
		sysEMR.addService(serClinical);
		//Order service
		Service serOrder = new Service("Order");
		Interface intSendOrder = new Interface("SendOrder", Util.PROTOCOL_HL7);
		serOrder.addInterface(intSendOrder);
		Interface intSendOrderFee = new Interface("SendOrderFee", Util.PROTOCOL_HL7);
		serOrder.addInterface(intSendOrderFee);
		sysEMR.addService(serOrder);
		//Diagnosis service
		Service serDiagnosis = new Service("Diagnosis");
		Interface intReceiveImage = new Interface("AcceptImage", Util.PROTOCOL_DICOM);
		serDiagnosis.addInterface(intReceiveImage);
		Interface intReceiveReport = new Interface("AcceptReport", Util.PROTOCOL_HL7);
		serDiagnosis.addInterface(intReceiveReport);
		sysEMR.addService(serDiagnosis);
		//add EMR
		model.addSystem(sysEMR);
		
		//RIS
		InfoSystem sysRIS = new InfoSystem("RIS");
		//Register service
		Service serRegister = new Service("Register");
		Interface intAcceptOrder = new Interface("AcceptOrder", Util.PROTOCOL_DATABASE);
		serRegister.addInterface(intAcceptOrder);
		Interface intAcceptFeeStatus = new Interface("AcceptFeeStatus",Util.PROTOCOL_DATABASE);
		serRegister.addInterface(intAcceptFeeStatus);
		sysRIS.addService(serRegister);
		//Study service
		Service serStudy = new Service("Study");
		Interface intSendImage = new Interface("SendImage", Util.PROTOCOL_DICOM);
		serStudy.addInterface(intSendImage);
		sysRIS.addService(serStudy);
		//Report service
		Service serReport = new Service("Report");
		Interface intSendReport = new Interface("SendReport",Util.PROTOCOL_FILE);
		serReport.addInterface(intSendReport);
		sysRIS.addService(serReport);
		//add RIS
		model.addSystem(sysRIS);
		//load system semantic
//		InfoSystem sysBookFinder = new InfoSystem("BookFinder");
//		Service serFindService = new Service("Find Book");
//		serFindService.addInterface(Interface.loadSemanticWS("N:/InterfaceEngine/semantic/AmazonBookPrice.owl"));
//		sysBookFinder.addService(serFindService);
		InfoSystem sysBookFinder = InfoSystem.loadSemanticInfoSystem("N:/InterfaceEngine/semantic/AmazonBookPrice.owl");
		model.addSystem(sysBookFinder);
		
		
		return model;
	}

}
