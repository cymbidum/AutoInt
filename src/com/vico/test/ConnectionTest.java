package com.vico.test;

import java.util.Iterator;
import java.util.List;

import com.vico.model.Connection;
import com.vico.model.Transaction;

public class ConnectionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Transaction> transactions = ProcessModelTest.prepareProcessModel(
				SystemModelTest.prepareSystemModel()
				).getTransactions();
		Iterator<Transaction> iter = transactions.iterator();
		while(iter.hasNext()){
			Connection con = new Connection(iter.next());
			System.out.println(con);
		}
	}
	

}
