package tw.com.nik.itinerarymanager.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.nik.itinerarymanager.model.bean.Itinerary;
import tw.com.nik.itinerarymanager.service.ItineraryService;

@WebServlet("/getItinerary.do")
public class GetItineraryByJourneyId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		Integer journeyId = Integer.valueOf(request.getParameter("journey_id"));

		try {
			
		ItineraryService itineraryService = new ItineraryService();
		List<Itinerary> itineraries = itineraryService.getItineraryByJourneyId(journeyId);
		Map<Date, List<Itinerary>> itinerariesByDate = new HashMap<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		for (Itinerary itinerary : itineraries) {
			Date date;
				date = dateFormat.parse(itinerary.getItineraryStartDate().toString());
			if (!itinerariesByDate.containsKey(date)) {
				itinerariesByDate.put(date, new ArrayList<>());
			}
			itinerariesByDate.get(date).add(itinerary);
		}

		request.getSession().setAttribute("itineraries", itineraries);
		request.getSession().setAttribute("itinerariesByDate", itinerariesByDate);

		request.getRequestDispatcher("/itinerary").forward(request, response);
		
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
