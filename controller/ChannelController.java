package com.tcs.ilp.infinity.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.infinity.model.Channel;
import com.tcs.ilp.infinity.service.ChannelService;

/**
 * Servlet implementation class ChannelController
 */
@WebServlet("/ChannelController")
public class ChannelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int channelID; 
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChannelController() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Channel searchChannel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IN SEARCH CUSTOMER METHOD");
		String channelID = request.getParameter("search");	
		ChannelService chan = new ChannelService();
		Channel channel = chan.searchChannel(channelID);
		System.out.println("Search Success");
		return channel;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Channel c = null;
		String action = request.getParameter("action");
		
		if("searchNUpdate".equals(action)){
			c = searchChannel(request,response);
			channelID = c.getChannelID();
			System.out.println("SEARCH N UPDATE PRINTING OUT CHAN ID:" + c.getChannelID());
			request.setAttribute("channel", c);
			request.setAttribute("channelID", c.getChannelID());
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/channels/updateChannel.jsp");
			reqDispatcher.forward(request, response);	
		}
		//search
		else if(("searchChannel").equals(action)){
			System.out.println("WE are in SEARCH IF");
			 c = searchChannel(request,response);
		
			if (c == null){
				request.setAttribute("msg", "Channel not found");
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
				reqDispatcher.forward(request, response);

			} else {
				request.setAttribute("channel", c);
				System.out.println(c.getChannelName());
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("/channel/searchChannelResults.jsp");
				reqDispatcher.forward(request, response);	
			}
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ChannelControler::doPost invoked");
		String action = request.getParameter("action");
		System.out.println("User action received by controller =" + action);

		if("createChannel".equals(action)){
			Channel channel = new Channel();
			channel.setChannelName(request.getParameter("channelName"));
			channel.setChannelBand(request.getParameter("channelBand"));
			channel.setVideoCarrierFreq(request.getParameter("videoCarrierFrequency"));
			channel.setAudioCarrierFreq(request.getParameter("audioCarrierFrequency"));
			channel.setChannelChargeType(request.getParameter("channelChargeType"));
			channel.setChannelTransmissionType(request.getParameter("channelTransmissionType"));
			channel.setChannelCharge(request.getParameter("channelCharge"));
			//Call service layer to do customer search
			ChannelService channelService = new ChannelService();
			int channelID = channelService.createChannel(channel);

			String msg = null;
			if (channelID > 0){
				msg = "Channel is created. Please note the Channel ID: " + channelID;
			} else {
				msg = "Channel is NOT created. Please try again!";
			}
			request.setAttribute("msg", msg);

			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
			reqDispatcher.forward(request, response);
		
		
		} 	
		 else if("updateChannel".equals(action)) {
			 System.out.println("We are in update");
				Channel c = new Channel();
				c.setChannelID(Integer.parseInt(request.getParameter("channelID")));
				c.setChannelName(request.getParameter("channelName"));
				c.setChannelBand(request.getParameter("channelBand"));
				c.setVideoCarrierFreq(request.getParameter("videoCarrierFrequency"));
				c.setAudioCarrierFreq(request.getParameter("audioCarrierFrequency"));
				c.setChannelChargeType(request.getParameter("channelChargeType"));
				c.setChannelTransmissionType(request.getParameter("channelTransmissionType"));
				c.setChannelCharge(request.getParameter("channelCharge"));
				
				//Call service layer to do channel search
				ChannelService cService = new ChannelService();
				int channelID = cService.updateChannel(c);
				
				String msg = null;
				if (channelID > 0){
					msg = "Channel is updated. :)";
				} else {
					msg = "Channel did not update :(";
				}
				//Share the matched customers details with the view
				request.setAttribute("msg", msg);
				System.out.println("Updated " + c.getChannelID());
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
				reqDispatcher.forward(request, response);
				
		}
		 else if("deleteChannel".equals(action)) {
				ChannelService cService = new ChannelService();
				int status = cService.deleteChannel(Integer.valueOf(request.getParameter("deleteChannel")));
				
				String msg = null;
				if (status > 0){
					msg = "Channel is deleted. :)";
				} else {
					msg = "Channel did not deleted :(";
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
