package com.tcs.ilp.infinity.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.infinity.model.Customer;
import com.tcs.ilp.infinity.model.Retailer;
import com.tcs.ilp.infinity.service.CustomerService;
import com.tcs.ilp.infinity.service.RetailerService;

/**
 * Servlet implementation class RetailerController
 */
@WebServlet("/RetailerController")
public class RetailerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetailerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("RetailerControler::doGet invoked");
			String action = request.getParameter("action");
			System.out.println("User action received by controller =" + action);
			
			if("searchRetailer".equals(action)){

				//Call service layer to do Retailer search
				RetailerService retailerService = new RetailerService();
				Retailer rp = retailerService.searchRetailer(Integer.valueOf(request.getParameter("ID")));
				//Share the matched customers details with the view
				request.setAttribute("Retailer", rp);
				
				
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("/retailer/retailerSearchResult.jsp");
				reqDispatcher.forward(request, response);
			} else if("searchNUpdateRetailer".equals(action)){
				//Call service layer to do Retailer search
				RetailerService retailerService = new RetailerService();
				Retailer rp = retailerService.searchRetailer(Integer.valueOf(request.getParameter("searchNUpdateRetailer")));
				//Share the matched customers details with the view
				request.setAttribute("retailer", rp);
				
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("/retailer/updateRetailer.jsp");
				reqDispatcher.forward(request, response);
			}
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RetailerRetailer::doPost invoked");
		String action = request.getParameter("action");
		System.out.println("User action received by controller =" + action);
	
		if("createRetailer".equals(action))
		{
			Retailer rt = new Retailer();
			rt.setName(request.getParameter("name"));
			rt.setContactNo1(request.getParameter("contactNo1"));
			rt.setContactNo2(request.getParameter("contactNo2"));
			rt.setAddress1(request.getParameter("address1"));
			rt.setAddress2(request.getParameter("address2"));
			rt.setCity(request.getParameter("city"));
			rt.setState(request.getParameter("state"));
			rt.setPinCode(request.getParameter("pinCode"));
			rt.setSetTopBoxLimit(request.getParameter("setTopBoxLimit"));
			rt.setCreditLimit(request.getParameter("creditLimit"));
			rt.setCommissionPercentage(request.getParameter("commissionPercentage"));
			rt.setServiceCharge(request.getParameter("serviceCharge"));		
			
			RetailerService rts = new RetailerService();
			int rtID = rts.createRetailer(rt);
			
			String msg = null;
			if (rtID > 0){
				msg = "Retailer is created. Please note the Retailer ID: " + rtID;
			} else {
				msg = "Retailer is NOT created. Please try again!";
			}
			//Share the matched retailer details with the view
			request.setAttribute("msg", msg);	
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
			reqDispatcher.forward(request, response);
			
		}
		
		else if("deleteRetailer".equals(action)){
			doDelete(request, response);
		}
		else if("updateRetailer".equals(action)){
			Retailer rt = new Retailer();
			rt.setRetailerID(Integer.valueOf(request.getParameter("retailerID")));
			rt.setName(request.getParameter("name"));
			rt.setContactNo1(request.getParameter("contactNo1"));
			rt.setContactNo2(request.getParameter("contactNo2"));
			rt.setAddress1(request.getParameter("address1"));
			rt.setAddress2(request.getParameter("address2"));
			rt.setCity(request.getParameter("city"));
			rt.setState(request.getParameter("state"));
			rt.setPinCode(request.getParameter("pinCode"));
			rt.setSetTopBoxLimit(request.getParameter("setTopBoxLimit"));
			rt.setCreditLimit(request.getParameter("creditLimit"));
			rt.setCommissionPercentage(request.getParameter("commissionPercentage"));
			rt.setServiceCharge(request.getParameter("serviceCharge"));		
			
			RetailerService rts = new RetailerService();
			int rtID = rts.updateRetailer(rt);

			String msg = null;
			if (rtID > 0){
				msg = "Retailer is updated.";
			} else {
				msg = "Retailer is NOT updated.";
			}
			//Share the matched retailer details with the view
			request.setAttribute("msg", msg);	
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
			reqDispatcher.forward(request, response);
			
		}
	}
	
	

	private void modifiedRet(HttpServletRequest request,HttpServletResponse response) {
		RetailerService rService = new RetailerService();
		Retailer ro = new Retailer();	
		//we add the fields to our customer
		ro.setName(request.getParameter("name"));
		ro.setContactNo1(request.getParameter("contactNo1"));
		ro.setContactNo2(request.getParameter("contactNo2"));
		ro.setAddress1(request.getParameter("address1"));
		ro.setAddress2(request.getParameter("address2"));
		ro.setCity(request.getParameter("city"));
		ro.setState(request.getParameter("state"));
		ro.setPinCode(request.getParameter("pinCode"));
		ro.setSetTopBoxLimit(request.getParameter("setTopBoxLimit"));
		ro.setCreditLimit(request.getParameter("creditLimit"));
		ro.setCommissionPercentage(request.getParameter("commissionPercentage"));
		ro.setServiceCharge(request.getParameter("serviceCharge"));
		//ro.setRetailerID(retailerId);
		System.out.println("PRINTING OUT RETAILER ID:" + ro.getRetailerID());
		
		String message = "";
		
		if(rService.updateRetailer(ro) == 1){
			message = "Retailer Update Successful";
		}
		else{
			message = "Retailer Update Failure";
			
		}
		request.setAttribute("msg", message);
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/retailerResults.jsp");
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
		System.out.println("Retailer Controller::doDelete invoked");
		String action = request.getParameter("action");
		System.out.println("User action received by controller =" + action);

		if("deleteRetailer".equals(action)){

			/*Call service layer to do retailer search*/
			RetailerService rService = new RetailerService();
			
			int status = rService.deleteRetailer(Integer.parseInt(request.getParameter("retailerID")));
			String message = null;
			if(status == 1){
				message = "Retailer Deletion successful";
			} else {
				message = "Retailer Deletion failed";
			}
			request.setAttribute("msg", message);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
			reqDispatcher.forward(request, response);
		}
	}

}
