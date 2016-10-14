package com.tcs.ilp.infinity.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.infinity.model.Customer;
import com.tcs.ilp.infinity.model.Distributor;
import com.tcs.ilp.infinity.model.SetTopBox;
import com.tcs.ilp.infinity.service.CustomerService;
import com.tcs.ilp.infinity.service.DistributorService;
import com.tcs.ilp.infinity.service.SetTopBoxService;

/**
 * Servlet implementation class DistributorController
 */
@WebServlet("/DistributorController")
public class DistributorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistributorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DistributorControler::doGet invoked");
		String action = request.getParameter("action");
		System.out.println("User action received by controller =" + action);
		Distributor dst = null;
		
		if("searchNUpdateDistributor".equals(action))
		{
			DistributorService distributorServ = new DistributorService();
			Distributor dist = distributorServ.searchDistributor(request.getParameter("search"));			
			request.setAttribute("dst", dist);
			
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/distributor/updateDistributor.jsp");
			reqDispatcher.forward(request,response);
		}
		
		else if ("searchDistributor".equals(action))
		{
			DistributorService distServ = new DistributorService();
			Distributor dis = distServ.searchDistributor(request.getParameter("search"));
			request.setAttribute("dst", dis);
			
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/distributor/searchDistributorResult.jsp");
			reqDispatcher.forward(request, response);
		}
		
	}
		
	private Distributor searchDistributor(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("IN SEARCH Distributor METHOD");
		String DistributorID = request.getParameter("search");	
		DistributorService stbService = new DistributorService();
		Distributor dstSearch = stbService.searchDistributor(DistributorID);
		System.out.println("Search Success");
		return dstSearch;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("distributorController::doPost invoked");
		String action = request.getParameter("action");
		System.out.println("User action received by controller =" + action);
		
		if ("createDistributor".equals(action)){
			Distributor dist = new Distributor();	
			dist.setDistributorName(request.getParameter("name"));
			dist.setContact1(request.getParameter("contactNo1"));
			dist.setContact2(request.getParameter("contactNo2"));
			dist.setAddress1(request.getParameter("address1"));
			dist.setAddress2(request.getParameter("address2"));
			dist.setCity(request.getParameter("city"));
			dist.setPinCode(request.getParameter("pinCode"));
			dist.setZone(request.getParameter("zone"));
			dist.setSetTopBoxLimit(request.getParameter("setTopBoxLimit"));
			dist.setCreditLimit(request.getParameter("creditLimit"));
			
			DistributorService distService = new DistributorService();
			int distID = distService.createDistributor(dist);

			String msg = null;
			if (distID > 0){
				msg = "Distributo is created. Please note the Customer ID: " + distID;
			} else {
				msg = "Distributor is NOT created. Please try again!";
			}			
			request.setAttribute("msg", msg);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
			reqDispatcher.forward(request, response);			
		}	
		else if ("updateDistributor".equals(action))
		{
			Distributor dst = new Distributor();
			dst.setDistributorID(Integer.parseInt(request.getParameter("distributorID")));
			dst.setDistributorName(request.getParameter("name"));
			dst.setContact1(request.getParameter("contactNo1"));
			dst.setContact2(request.getParameter("contactNo2"));
			dst.setAddress1(request.getParameter("address1"));
			dst.setAddress2(request.getParameter("address2"));
			dst.setCity(request.getParameter("city"));
			dst.setPinCode(request.getParameter("pinCode"));
			dst.setZone(request.getParameter("zone"));
			dst.setSetTopBoxLimit(request.getParameter("setTopBoxLimit"));
			dst.setCreditLimit(request.getParameter("creditLimit"));
			
			DistributorService distServ = new DistributorService();
			int distServID = distServ.updateDistributor(dst);
			
			String msg = null;
			if (distServID > 0){
				msg = "Distributor is updated. :)";
			} else {
				msg = "Distributor did not update :(";
			}
			//Share the matched customers details with the view
			request.setAttribute("msg", msg);
			
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
			reqDispatcher.forward(request, response);		
		}
		else if ("deleteDistributor".equals(action))
		{
			DistributorService dstService = new DistributorService();
			int status = dstService.deleteDistributor(Integer.valueOf(request.getParameter("deleteDistributor")));
			
			String msg = null;
			if (status > 0){
				msg = "Distributor is deleted. :)";
			} else {
				msg = "Distributor did not deleted :(";
			}
			//Share the matched customers details with the view
			request.setAttribute("msg", msg);
			
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
			reqDispatcher.forward(request, response);
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
