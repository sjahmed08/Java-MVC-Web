package com.tcs.ilp.infinity.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.infinity.model.ChannelPackage;
import com.tcs.ilp.infinity.model.Customer;
import com.tcs.ilp.infinity.service.ChannelPackageService;
import com.tcs.ilp.infinity.service.CustomerService;

/**
 * Servlet implementation class ChannelPackageController
 */
@WebServlet("/ChannelPackageController")
public class ChannelPackageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String channelPackageId; 
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChannelPackageController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChannelPackage c = null;
		String action = request.getParameter("action");
		//
		System.out.println(action);
		//
		if("searchNUpdate".equals(action)){
			c = searchChannelPackage(request,response);
			channelPackageId = c.getChannelPackageID();
			System.out.println("SEARCH N UPDATE PRINTING OUT CHANNEL PACKAGE ID:" + c.getChannelPackageID());
			request.setAttribute("channelPackage", c);
			request.setAttribute("channelPackageID", c.getChannelPackageID());
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/channelPackage/updateChannelPackage.jsp");
			reqDispatcher.forward(request, response);	
		}
		else if(("searchChannelPackage").equals(action)){
			System.out.println("WE are in SEARCH IF");
			c = searchChannelPackage(request,response);

			request.setAttribute("channelPackage", c);
			//
			System.out.println(c.getChannelPackageID());
			//
			//RequestDispatcher reqDispatcher = request.getRequestDispatcher("/channelPackage/searchDisplay.jsp");
			//reqDispatcher.forward(request, response);	
		}
	}

	private ChannelPackage searchChannelPackage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IN SEARCH CHANNEL PACKAGE METHOD");
		String channelPackageId = request.getParameter("search");	
		ChannelPackageService chanPack = new ChannelPackageService();
		ChannelPackage channelPackage = chanPack.searchChannelPackage(Integer.parseInt(channelPackageId));
		System.out.println("Search Success");
		return channelPackage;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ChannelPackageController::doPost invoked");
		String action = request.getParameter("action");
		System.out.println("User action received by controller =" + action);

		if("createChannelPackages".equals(action)){
			ChannelPackage channelPackage = new ChannelPackage();
			channelPackage.setPackageName(request.getParameter("packageName"));
			channelPackage.setPackageCategory(request.getParameter("packageCategory"));
			channelPackage.setPackageChargingType(request.getParameter("packageChargeType"));
			channelPackage.setPackageTransmissionType(request.getParameter("packageTransmissionType"));
			//todo			channelPackage.setAddChannels(request.getParameter("addChannels"));
			channelPackage.setPackageAvailStart(request.getParameter("packageAvailableFromDate"));
			channelPackage.setPackageAvailEnd(request.getParameter("packageAvailableToDate"));
			channelPackage.setAddedByDefault(request.getParameter("addedByDefault"));

			//Call service layer to do customer search
			ChannelPackageService channelPackageService = new ChannelPackageService();
			int packageID = channelPackageService.createChannelPackage(channelPackage);

			String msg = null;
			if (packageID > 0){
				msg = "Channel Package is created. Please note the Channel Package ID: " + packageID;
			} else {
				msg = "Channel Package is NOT created. Please try again!";
			}
			//Share the matched customers details with the view
			request.setAttribute("msg", msg);

			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
			reqDispatcher.forward(request, response);
		} 	
		else if ("searchChannelPackages".equals(action)){
			ChannelPackageService channelPackageService = new ChannelPackageService();
			ChannelPackage cp = channelPackageService.searchChannelPackage(Integer.parseInt(request.getParameter("channelPackageID")));
			
			if (cp == null){
				request.setAttribute("msg", "Channel Package not found");
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
				reqDispatcher.forward(request, response);

			} else {
				request.setAttribute("cp", cp);
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("/channelPackages/searchChannelPackageResults.jsp");
				reqDispatcher.forward(request, response);
			}
		}
		else if ("searchNUpdateChannelPackages".equals(action)){
			ChannelPackageService channelPackageService = new ChannelPackageService();
			ChannelPackage cp = channelPackageService.searchChannelPackage(Integer.parseInt(request.getParameter("channelPackageID")));

			request.setAttribute("cp", cp);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/channelPackages/updateChannelPackage.jsp");
			reqDispatcher.forward(request, response);
		}
		else if ("updateChannelPackages".equals(action)){
			ChannelPackage channelPackage = new ChannelPackage();
	
			channelPackage.setChannelPackageID(request.getParameter("channelPackageID"));
			channelPackage.setPackageName(request.getParameter("packageName"));
			channelPackage.setPackageCategory(request.getParameter("packageCategory"));
			channelPackage.setPackageChargingType(request.getParameter("packageChargeType"));
			channelPackage.setPackageTransmissionType(request.getParameter("packageTransmissionType"));
			//todo	channelPackage.setAddChannels(request.getParameter("addChannels"));
			channelPackage.setPackageAvailStart(request.getParameter("packageAvailableFromDate"));
			channelPackage.setPackageAvailEnd(request.getParameter("packageAvailableToDate"));
			channelPackage.setAddedByDefault(request.getParameter("addedByDefault"));
			
			ChannelPackageService channelPackageService = new ChannelPackageService();
			int status = channelPackageService.updateChannelPackage(channelPackage);
			
			
			String msg = null;
			if (status > 0){
				msg = "Channel Package is UPDATED";
			} else {
				msg = "Channel Package is NOT updated";
			}
			//Share the matched customers details with the view
			request.setAttribute("msg", msg);

			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
			reqDispatcher.forward(request, response);
		} else if ("deleteChannelPackages".equals(action)){
			doDelete(request, response);
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
		System.out.println("Channel Package Controller::doDelete invoked");
		String action = request.getParameter("action");
		System.out.println("User action received by controller =" + action);

		if("deleteChannelPackages".equals(action)){

			/*Call service layer to do customer search*/
			ChannelPackageService cService = new ChannelPackageService();

			int status = cService.deleteChannelPackage(request.getParameter("channelPackageID"));
			String message = null;
			if(status == 1){
				message = "Channel Package Deletion successful";
			} else {
				message = "Channel Package Deletion failed";
			}
			request.setAttribute("msg", message);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
			reqDispatcher.forward(request, response);
		}
	}

}
