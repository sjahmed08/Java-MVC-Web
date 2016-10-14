package com.tcs.ilp.infinity.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.tcs.ilp.infinity.model.SetTopBox;
import com.tcs.ilp.infinity.service.SetTopBoxService;

/**
 * Servlet implementation class SetTopBoxController
 */
@WebServlet("/SetTopBoxController")
public class SetTopBoxController extends HttpServlet {
	private static final long serialVersionUID = 1L;     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetTopBoxController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SetTopBoxController::doGet invoked");
		String action = request.getParameter("action");
		System.out.println("User action received by controller =" + action);
		
		if("searchNUpdateSetTopBox".equals(action)){
			
		
			SetTopBoxService stbService = new SetTopBoxService();
			SetTopBox s = stbService.searchSetTopBox(request.getParameter("searchNUpdateSetTopBox"));
			request.setAttribute("stb", s);
			
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/setTopBox/updateSetTopBox.jsp");
			reqDispatcher.forward(request, response);
		}
		else if("searchSetTopBox".equals(action)){

			//Call service layer to do operator search
			SetTopBoxService stbService = new SetTopBoxService();
			SetTopBox s = stbService.searchSetTopBox(request.getParameter("searchSetTopBox"));
			request.setAttribute("stb", s);
			
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/setTopBox/SearchSetTopBoxResult.jsp");
			reqDispatcher.forward(request, response);
		} 
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("STBController::doPost invoked");
		String action = request.getParameter("action");
		System.out.println("User action received by controller =" + action);
		
		if("createSTB".equals(action)){
			SetTopBox stb = new SetTopBox();
			stb.setType(request.getParameter("setTopBoxType"));
			stb.setMacID(Double.valueOf(request.getParameter("setTopBoxMACID")));
			stb.setRemoteID(Double.valueOf(request.getParameter("remoteControlAssetId")));
			stb.setDishId(Double.valueOf(request.getParameter("dishAssetId")));
			
			
			//Call service layer to do STB search
			SetTopBoxService stbService = new SetTopBoxService();
			int setTopBoxID = stbService.createSetTopBox(stb);
			
			String msg = null;
			if (setTopBoxID > 0){
				msg = "Set Top Box is created. Please note the Set Top Box ID: " + setTopBoxID;
			} else {
				msg = "Set Top Box is NOT created. Please try again!";
			}
			//Share the matched customers details with the view
			request.setAttribute("msg", msg);
			
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
			reqDispatcher.forward(request, response);
		} else if("updateSTB".equals(action)) {
			SetTopBox stb = new SetTopBox();
			stb.setType(request.getParameter("setTopBoxType"));
			stb.setMacID(Double.valueOf(request.getParameter("setTopBoxMACID")));
			stb.setRemoteID(Double.valueOf(request.getParameter("remoteControlAssetId")));
			stb.setDishId(Double.valueOf(request.getParameter("dishAssetId")));
			stb.setStatus(request.getParameter("status"));
			stb.setSerial(Double.valueOf(request.getParameter("serialNo")));
			
			//Call service layer to do STB search
			SetTopBoxService stbService = new SetTopBoxService();
			int setTopBoxID = stbService.updateSetTopBox(stb);
			
			String msg = null;
			if (setTopBoxID > 0){
				msg = "Set-Top-Box is updated. :)";
			} else {
				msg = "Set-Top-Box did not update :(";
			}
			//Share the matched customers details with the view
			request.setAttribute("msg", msg);
			
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
			reqDispatcher.forward(request, response);
			
		} else if("deleteSetTopBox".equals(action)) {
			SetTopBoxService stbService = new SetTopBoxService();
			int status = stbService.deleteSetTopBox(Integer.valueOf(request.getParameter("deleteSetTopBox")));
			
			String msg = null;
			if (status > 0){
				msg = "Set-Top-Box is deleted. :)";
			} else {
				msg = "Set-Top-Box did not deleted :(";
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
