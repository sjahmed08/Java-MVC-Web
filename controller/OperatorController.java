package com.tcs.ilp.infinity.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.infinity.model.Operator;
import com.tcs.ilp.infinity.service.OperatorService;

/**
 * Servlet implementation class OperatorController
 */
@WebServlet("/OperatorController")
public class OperatorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int operatorID;
	static int deleteID;
	static String creationDate;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OperatorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OperatorControler::doGet invoked");
		String action = request.getParameter("action");
		System.out.println("User action received by controller =" + action);

		if("searchOperator".equals(action)){

			//Call service layer to do operator search
			OperatorService operatorService = new OperatorService();
			Operator op = operatorService.searchOperator(request.getParameter("emailID"));
			
			if(op == null){
				request.setAttribute("msg", "Operator not found");
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
				reqDispatcher.forward(request, response);
			} else {
				//Share the matched customers details with the view
				request.setAttribute("operator", op);
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("/operator/OperatorSearchResult.jsp");
				reqDispatcher.forward(request, response);
			}
		} 
	}
	
	private Operator searchOperator(HttpServletRequest request, HttpServletResponse response){
		//Call service layer to do operator search
		OperatorService operatorService = new OperatorService();
		Operator op = operatorService.searchOperator(request.getParameter("emailID"));
		return op;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("OperatorControler::doPost invoked");
		String action = request.getParameter("action");
		System.out.println("User action received by controller =" + action);
		Operator o = new Operator();
		if("createOperator".equals(action)){
			Operator op = new Operator();
			op.setFirstName(request.getParameter("firstName"));
			op.setLastName(request.getParameter("lastName"));
			op.setEmailID(request.getParameter("emailID"));
			op.setPhoneNumber(request.getParameter("phoneNumber"));
			op.setShiftTimeStart(request.getParameter("shiftTimeStart"));
			op.setMaxNoCustomers(request.getParameter("maxNoCustomers"));
			op.setPassword(request.getParameter("password"));

			//Call service layer to do customer search
			OperatorService operatorService = new OperatorService();
			int opID = operatorService.createOperator(op);

			String msg = null;
			if (opID > 0){
				msg = "Operator is created. Please note the Operator ID: " + opID;
			} else {
				msg = "Operator is NOT created. Please try again!";
			}
			//Share the matched customers details with the view
			request.setAttribute("msg", msg);

			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
			reqDispatcher.forward(request, response);
		} 

		else if("updateOperator".equals(action)){
			o = searchOperator(request,response);
			operatorID = o.getOperatorID();
			creationDate = o.getCreationDate();
		request.setAttribute("operator", o);
	
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/operator/updateOperator.jsp");
			reqDispatcher.forward(request, response);	
		}
		else if("modifyOperator".equals(action)){
			OperatorService oService = new OperatorService();
			o.setFirstName(request.getParameter("firstName"));
			o.setLastName(request.getParameter("lastName"));
			o.setEmailID(request.getParameter("emailID"));
			o.setMaxNoCustomers(request.getParameter("maxNoCustomers"));
			o.setPhoneNumber(request.getParameter("phoneNumber"));
			o.setShiftTimeEnd(request.getParameter("shiftTimeEnd"));
			o.setShiftTimeStart(request.getParameter("shiftTimeStart"));
			o.setOperatorID(operatorID);
			o.setCreationDate(creationDate);

			String message = "";
			
			if(oService.updateOperator(o) == 1){
				message = "Operator Update Successful";
			}
			else{
				message = "Operator Update Failure";
				
			}
			request.setAttribute("msg", message);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
			try {
				reqDispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(("deleteOperator").equals(action)){
			o = searchOperator(request,response);
			OperatorService oService = new OperatorService();
			
			String message = "";
			
			if(oService.deleteOperator( o.getOperatorID()) == 1){
				message = "Operator Delete Successful";
			}
			else{
				message = "Operator Delete Failure";
				
			}
			
			request.setAttribute("msg", message);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
			try {
				reqDispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
