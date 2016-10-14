package com.tcs.ilp.infinity.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.infinity.model.Video;
import com.tcs.ilp.infinity.service.VideoService;

/**
 * Servlet implementation class VideoController
 */
@WebServlet("/VideoController")
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("VideoControler::doGet invoked");
		String action = request.getParameter("action");
		System.out.println("User action received by controller =" + action);
	
		if("searchVideo".equals(action)){
			
			String videoID = request.getParameter("searchVideo");	
			VideoService vid = new VideoService();
			Video video = vid.searchVideo(videoID);

			if ( video == null){
				request.setAttribute("msg", "VIDEO NOT FOUND");
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
				reqDispatcher.forward(request, response);
			} else{
				request.setAttribute("video", video);

				RequestDispatcher reqDispatcher = request.getRequestDispatcher("/video/VideoSearchResult.jsp");
				reqDispatcher.forward(request, response);
			}
		}
			
			/*
			//Call service layer to do operator search
			VideoService videoService = new VideoService();
			Video op = videoService.searchVideo(request.getParameter("searchVideo"));
			System.out.println(request.getParameter("searchVideo"));
			System.out.println(op.getVideoName());
			//Share the matched customers details with the view
			request.setAttribute("Video", op);
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/video/VideoSearchResult.jsp");
			reqDispatcher.forward(request, response);
		} */
		
		
		else if(("searchNUpdate").equals(action)){
			String videoID = request.getParameter("search");	
			VideoService vid = new VideoService();
			Video video = vid.searchVideo(videoID);
			
			if ( video == null){
				request.setAttribute("msg", "VIDEO NOT FOUND");
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
				reqDispatcher.forward(request, response);
			} else{
				request.setAttribute("video", video);
				
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("/video/updateVideo.jsp");
				reqDispatcher.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("VideoControler::doPost invoked");
		String action = request.getParameter("action");
		System.out.println("User action received by controller =" + action);
		
		if("createVideo".equals(action)){
			Video op = new Video();
			op.setVideoName(request.getParameter("videoName"));
			op.setVideoCategory(request.getParameter("videoCategory"));
			op.setVideoDuration(request.getParameter("videoDuration"));
			op.setVideoFrequency(request.getParameter("videoFrequency"));
			op.setVideoStartTime(request.getParameter("videoStartTime"));
			op.setVideoEndTime(request.getParameter("videoEndTime"));
			op.setVideoCost(request.getParameter("videoCost"));
			op.setPreview(request.getParameter("preview"));
			//Call service layer to do customer search
			VideoService videoService = new VideoService();
			int videoID = videoService.createVideo(op);
			
			String msg = null;
			if (videoID > 0){
				msg = "Video is created. Please note the Video ID: " + videoID;
			} else {
				msg = "Video is NOT created. Please try again!";
			}
			request.setAttribute("msg", msg);
			
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
			reqDispatcher.forward(request, response);
		} else if("updateVideo".equals(action)){
			
			Video video = new Video();
			video.setVideoID(Integer.valueOf(request.getParameter("videoID")));
			video.setVideoName(request.getParameter("videoName"));
			video.setVideoCategory(request.getParameter("videoCategory"));
			video.setVideoDuration(request.getParameter("videoDuration"));
			video.setVideoFrequency(request.getParameter("videoFrequency"));
			video.setVideoStartTime(request.getParameter("videoStartTime"));
			video.setVideoEndTime(request.getParameter("videoEndTime"));
			video.setVideoCost(request.getParameter("videoCost"));
			video.setPreview(request.getParameter("videoPreview"));
			System.out.println("here");
			
			VideoService videoService = new VideoService();	
			videoService.updateVideo(video);
			request.setAttribute("msg", "Video updated");
			
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Results.jsp");
			reqDispatcher.forward(request, response); 	
			
		}
		else if("deleteVideo".equals(action)) {
			VideoService videoService = new VideoService();
			int status = videoService.deleteVideo(Integer.valueOf(request.getParameter("deleteVideo")));
			
			String msg = null;
			if (status > 0){
				msg = "Video is deleted. :)";
			} else {
				msg = "Video did not deleted :(";
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
