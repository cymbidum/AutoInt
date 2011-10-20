package com.vico.test;

import com.vico.model.Topology;

public class TopologyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Topology tp = new Topology(ProcessModelTest.prepareProcessModel(SystemModelTest.prepareSystemModel()));
		System.out.println(tp);
	} 

}
