package com.tcs.ilp.infinity.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.infinity.model.Customer;
import com.tcs.ilp.infinity.service.CustomerService;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int custId;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer c = null;
		String action = request.getParameter("action");
		if("searchNUpdate".equals(action)){
			c = searchCustomer(request,response);
			custId = c.getCustomerID();
			System.out.println("SEARCH N UPDATE PRINTING OUT CUST ID:" + c.getCustomerID());
			request.setAttribute("customer", c);
			request.setAttribute("customerID", c.getCustomerID());
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/customer/updateCustomer.jsp");
			reqDispatcher.forward(request, response);	
		}
		else if(("searchCustomer").equals(action)){
			System.out.println("WE are in SEARCH IF");
			 c = searchCustomer(request,response);
		
			request.setAttribute("customer", c);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/customer/searchDisplay.jsp");
			reqDispatcher.forward(request, response);	
		}
	}
	
	private Customer searchCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IN SEARCH CUSTOMER METHOD");
		String emailID = request.getParameter("search");	
		CustomerService cust = new CustomerService();
		Customer customer = cust.searchCustomer(emailID);
		System.out.println("Search Success");
		return customer;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CustomerController::doPost invoked");
		String action = request.getParameter("action");
		System.out.println("User action received by controller =" + action);
	
		if ("createCustomer".equals(action)){
			Customer co = new Customer();	
			co.setFirstName(request.getParameter("firstName"));
			co.setLastName(request.getParameter("lastName"));
			co.setEmailID(request.getParameter("emailID"));
			co.setPhoneNumber(request.getParameter("phoneNumber"));
			co.setAddress1(request.getParameter("address1"));
			co.setAddress2(request.getParameter("address2"));
			co.setLandMark(request.getParameter("landMark"));
			co.setPinCode(request.getParameter("pinCode"));
			co.setCity(request.getParameter("city"));
			co.setState(request.getParameter("state"));
			co.setPassword(request.getParameter("password"));
			
			CustomerService customerService = new CustomerService();
			int coID = customerService.createCustomer(co, null);
			
			String msg = null;
			if (coID > 0){
				msg = "Customer is created. Please note the Customer ID: " + coID;
			} else {
				msg = "Customer is NOT created. Please try again!";
			}
			
			request.setAttribute("msg", msg);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
			reqDispatcher.forward(request, response);			
		}
		else if("deleteCustomer".equals(action)){
			doDelete(request, response);
		}
		else if("modifiedCustomer".equals(action)){
			modifiedCust(request,response);
		}
		
	}
	
	private void modifiedCust(HttpServletRequest request,HttpServletResponse response) {
		//Customer c = new Customer();
		CustomerService cService = new CustomerService();
		/*add the parameters to upCust depending on JSP file format;*/
		Customer co = new Customer();	
		//we add the fields to our customer
		co.setFirstName(request.getParameter("firstName"));
		co.setLastName(request.getParameter("lastName"));
		co.setEmailID(request.getParameter("emailID"));
		co.setPhoneNumber(request.getParameter("phoneNumber"));
		co.setAddress1(request.getParameter("address1"));
		co.setAddress2(request.getParameter("address2"));
		co.setLandMark(request.getParameter("landMark"));
		co.setPinCode(request.getParameter("pinCode"));
		co.setCity(request.getParameter("city"));
		co.setState(request.getParameter("state"));
		co.setCustomerID(custId);
		System.out.println("PRINTING OUT CO ID:" + co.getCustomerID());
		
		String message = "";
		
		if(cService.updateCustomer(co) == 1){
			message = "Customer Update Successful";
		}
		else{
			message = "Customer Update Failure";
			
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
		System.out.println("Customer Controller::doDelete invoked");
		String action = request.getParameter("action");
		System.out.println("User action received by controller =" + action);

		if("deleteCustomer".equals(action)){

			/*Call service layer to do customer search*/
			CustomerService cService = new CustomerService();
			
			int status = cService.deleteCustomer(request.getParameter("emailID"));
			String message = null;
			if(status == 1){
				message = "Customer Deletion successful";
			} else {
				message = "Customer Deletion failed";
			}
			request.setAttribute("msg", message);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
			reqDispatcher.forward(request, response);
		}
	}

}
