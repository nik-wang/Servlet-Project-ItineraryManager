package tw.com.nik.itinerarymanager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.nik.itinerarymanager.model.bean.Member;
import tw.com.nik.itinerarymanager.service.JourneyService;
import tw.com.nik.itinerarymanager.service.MemberService;

@WebServlet("/deleteJourney.do")
public class DeleteJourney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Integer journeyId = Integer.valueOf(request.getParameter("journey_id"));
		
		JourneyService journeyService = new JourneyService();
		journeyService.deleteJourneyById(journeyId);
	
		response.sendRedirect("my_journey");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
