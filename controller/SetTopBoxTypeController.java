package com.tcs.ilp.infinity.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.infinity.model.SetTopBoxType;
import com.tcs.ilp.infinity.service.SetTopBoxTypeService;

/**
 * Servlet implementation class SetTopBoxTypeController
 */
@WebServlet("/SetTopBoxTypeController")
public class SetTopBoxTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetTopBoxTypeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("STBTypeController::doPost invoked");
		String action = request.getParameter("action");
		System.out.println("User action received by controller =" + action);
		
		if("createSTBType".equals(action)){
			SetTopBoxType stbType = new SetTopBoxType();
			stbType.setType(request.getParameter("setTopBoxType"));
			stbType.setFeatures(request.getParameter("setTopBoxFeatures"));	
			stbType.setLength(Double.valueOf(request.getParameter("Length")));
			stbType.setBreadth(Double.valueOf(request.getParameter("Breadth")));
			stbType.setWidth(Double.valueOf(request.getParameter("Width")));
			stbType.setPrice(Double.valueOf(request.getParameter("Price")));
			stbType.setInstallCharges(Double.valueOf(request.getParameter("installationCharges")));
			stbType.setUpgradationCharges(Double.valueOf(request.getParameter("upgradationCharge")));
			stbType.setDiscount(Double.valueOf(request.getParameter("discount")));
			System.out.println("test completed");
			//Call service layer to do stbtype search
			SetTopBoxTypeService stbTypeService = new SetTopBoxTypeService();
			int setTopBoxTypeID = stbTypeService.createSetTopBoxType(stbType);
			
			String msg = null;
			if (setTopBoxTypeID > 0){
				msg = "Set Top Box Type is created. Please note the Set Top Box Type ID: " + setTopBoxTypeID;
			} else {
				msg = "Set Top Box Type is NOT created. Please try again!";
			}
			
			//Share the matched stbtype details with the view
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
