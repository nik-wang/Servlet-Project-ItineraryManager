package tw.com.nik.itinerarymanager.service;

import java.sql.Connection;
import java.util.List;

import tw.com.nik.itinerarymanager.model.bean.Journey;
import tw.com.nik.itinerarymanager.model.dao.JourneyDAOImpl;
import tw.com.nik.itinerarymanager.util.ConnectionFactory;

public class JourneyService {

	public void addJourney(Journey journey) {
		try (Connection conn = ConnectionFactory.getConnection()) {

			JourneyDAOImpl journeyDAOImpl = new JourneyDAOImpl(conn);
			journeyDAOImpl.createJourney(journey);

		} catch (Exception e) {
			throw new RuntimeException("Fail to add journey: " + e.getMessage());
		}
	}
	
	public List<Journey> getJourneyByMemberId(int memberId){
		
		try (Connection conn = ConnectionFactory.getConnection()) {

			JourneyDAOImpl journeyDAOImpl = new JourneyDAOImpl(conn);
			List<Journey> journeyList = journeyDAOImpl.findJourneyByMemberId(memberId);

			return journeyList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public List<Journey> getAllJourney() {

		try (Connection conn = ConnectionFactory.getConnection()) {

			JourneyDAOImpl journeyDAOImpl = new JourneyDAOImpl(conn);
			List<Journey> journeyList = journeyDAOImpl.findAllJourney();

			return journeyList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Journey> getCertainJourney(String journeyName){
		
		try (Connection conn = ConnectionFactory.getConnection()) {

			JourneyDAOImpl journeyDAOImpl = new JourneyDAOImpl(conn);
			List<Journey> journeyList = journeyDAOImpl.fuzzySearchAllJourney(journeyName);

			return journeyList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Journey> getAllJourneyIsPublic(Boolean isPublic) {

		try (Connection conn = ConnectionFactory.getConnection()) {

			JourneyDAOImpl journeyDAOImpl = new JourneyDAOImpl(conn);
			List<Journey> journeyList = journeyDAOImpl.findAllJourneyIsPublic(isPublic);

			return journeyList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Journey> getJourneyByIdAndIsUpcoming(Integer memberId){
		
		try (Connection conn = ConnectionFactory.getConnection()) {

			JourneyDAOImpl journeyDAOImpl = new JourneyDAOImpl(conn);
			List<Journey> journeyList = journeyDAOImpl.findJourneyByMemberIdAndIsUpcoming(memberId);

			return journeyList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void deleteJourneyById(Integer memberId) {
		try (Connection conn = ConnectionFactory.getConnection()) {

			JourneyDAOImpl journeyDAOImpl = new JourneyDAOImpl(conn);
			journeyDAOImpl.deleteJourneyById(memberId);

		} catch (Exception e) {
			throw new RuntimeException("Fail to delete journey: " + e.getMessage());
		}
	}

}
