package com.tcs.ilp.infinity.service;

import com.tcs.ilp.infinity.dao.OperatorDAO;
import com.tcs.ilp.infinity.model.Operator;

public class OperatorService {
	public int createOperator(Operator operator){
		OperatorDAO operatorDAO = new OperatorDAO();
		return operatorDAO.createOperator(operator);
	}
	
	public Operator searchOperator(String emailID){
		OperatorDAO operatorDAO = new OperatorDAO();
		return operatorDAO.searchOperator(emailID);
	}
	
	public int updateOperator(Operator operator){
		OperatorDAO operatorDAO = new OperatorDAO();
		return operatorDAO.updateOperator(operator);
	}
	
	public int deleteOperator(int operatorID){
		OperatorDAO operatorDAO = new OperatorDAO();
		return operatorDAO.deleteOperator(operatorID);
	}
}
