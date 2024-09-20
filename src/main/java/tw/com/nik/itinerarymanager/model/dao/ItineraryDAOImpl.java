package tw.com.nik.itinerarymanager.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.com.nik.itinerarymanager.model.bean.Itinerary;

public class ItineraryDAOImpl implements ItineraryDAO {

	private Connection conn;

	public ItineraryDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void createItinerary(Itinerary itinerary) {
		// TODO Auto-generated method stub

	}

	@Override
	public Itinerary findItineraryById(int itineraryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Itinerary> findItineraryByJourneyId(int journeyId) throws SQLException {

		String sql = "SELECT * FROM [ItineraryManager].[dbo].[Itinerary] WHERE [fk_journey_id]=?";
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setInt(1, journeyId);
		ResultSet rs = prepareStatement.executeQuery();
		
		List<Itinerary> itineraryList = new ArrayList<>();
		
		while(rs.next()) {
			Itinerary itinerary = new Itinerary();
			itinerary.setItineraryId(rs.getInt(1));
			itinerary.setItineraryStartDate(rs.getDate(2));
			itinerary.setItineraryEndDate(rs.getDate(3));
			itinerary.setItineraryStartTime(rs.getTime(4));
			itinerary.setItineraryEndTime(rs.getTime(5));
			itinerary.setItineraryName(rs.getString(6));
			itinerary.setDestination(rs.getString(7));
			itinerary.setUrl(rs.getString(8));
			itinerary.setCategory(rs.getString(9));
			itinerary.setDescription(rs.getString(10));
			itinerary.setNote(rs.getString(11));
			itinerary.setBudget(rs.getInt(12));
			itinerary.setIsPaid(rs.getBoolean(13));
			itinerary.setIsChecked(rs.getBoolean(14));
			itinerary.setJourneyId(rs.getInt(15));
			
			itineraryList.add(itinerary);
			
		}
		
		rs.close();
		prepareStatement.close();

		return itineraryList;
	}

	@Override
	public List<Itinerary> findItineraryByJourneyIdAndIfChecked(int journeyId, Boolean ifChecked) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateItineraryById(int itineraryId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteItineraryById(int itineraryId) {
		// TODO Auto-generated method stub

	}

}
