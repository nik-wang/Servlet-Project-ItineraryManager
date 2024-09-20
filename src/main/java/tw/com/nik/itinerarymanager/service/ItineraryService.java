package tw.com.nik.itinerarymanager.service;

import java.sql.Connection;
import java.util.List;

import tw.com.nik.itinerarymanager.model.bean.Itinerary;
import tw.com.nik.itinerarymanager.model.dao.ItineraryDAOImpl;
import tw.com.nik.itinerarymanager.util.ConnectionFactory;

public class ItineraryService {
	
	public List<Itinerary> getItineraryByJourneyId(int journeyId) {
		
		try (Connection conn = ConnectionFactory.getConnection()) {

			ItineraryDAOImpl journeyDAOImpl = new ItineraryDAOImpl(conn);
			List<Itinerary> itineraryList = journeyDAOImpl.findItineraryByJourneyId(journeyId);

			return itineraryList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}

}
