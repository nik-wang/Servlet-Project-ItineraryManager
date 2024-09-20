package tw.com.nik.itinerarymanager.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.com.nik.itinerarymanager.model.bean.Journey;

public class JourneyDAOImpl implements JourneyDAO {

	private Connection conn;

	public JourneyDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void createJourney(Journey journey) throws SQLException {

		String sql = "  INSERT INTO [ItineraryManager].[dbo].[Journey](" + " [journey_name]" + ",[journey_start_date]"
				+ ",[journey_end_date]" + ",[journey_photo]" + ",[is_public]" + ",[fk_member_id])"
				+ "VALUES(?,?,?,?,?,?)";

		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setString(1, journey.getJourneyName());

		if (journey.getJourneyStartDate() == null) {
			prepareStatement.setNull(2, java.sql.Types.DATE);
		} else {
			prepareStatement.setDate(2, journey.getJourneyStartDate());
		}

		if (journey.getJourneyEndDate() == null) {
			prepareStatement.setNull(3, java.sql.Types.DATE);
		} else {
			prepareStatement.setDate(3, journey.getJourneyEndDate());
		}

		if (journey.getJourneyPhoto() == null) {
			prepareStatement.setNull(4, java.sql.Types.VARCHAR);
		} else {
			prepareStatement.setString(4, journey.getJourneyPhoto());
		}

		if (journey.getIsPublic() == null) {
			prepareStatement.setNull(5, java.sql.Types.BIT);
		} else {
			prepareStatement.setBoolean(5, journey.getIsPublic());
		}

		if (journey.getMemberId() == null) {
			prepareStatement.setNull(6, java.sql.Types.INTEGER);
		} else {
			prepareStatement.setInt(6, journey.getMemberId());
		}

		prepareStatement.execute();
		prepareStatement.close();

	}

	@Override
	public Journey findJourneyById(int journeyId) {
		return null;
	}

	@Override
	public List<Journey> findJourneyByMemberId(int memberId) throws SQLException {
		
		String sql ="SELECT * FROM [ItineraryManager].[dbo].[Journey]"
				+ "WHERE [fk_member_id]=?";
		
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setInt(1, memberId);
		ResultSet rs = prepareStatement.executeQuery();
		
		List<Journey> journeyList = new ArrayList<>();
		
		while(rs.next()){
			Journey journey = new Journey();
			journey.setJourneyId(rs.getInt(1));
			journey.setJourneyName(rs.getString(2));
			journey.setJourneyStartDate(rs.getDate(3));
			journey.setJourneyEndDate(rs.getDate(4));
			journey.setJourneyPhoto(rs.getString(5));
			journey.setIsPublic(rs.getBoolean(6));
			journey.setMemberId(rs.getInt(7));
			
			journeyList.add(journey);
		}
		
		rs.close();
		prepareStatement.close();
						
		return journeyList;
	}
	
	@Override
	public List<Journey> findAllJourney() throws SQLException {
		
		String sql ="SELECT * FROM [ItineraryManager].[dbo].[Journey]";
		
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		ResultSet rs = prepareStatement.executeQuery();
		
		List<Journey> journeyList = new ArrayList<>();
		
		while(rs.next()){
			Journey journey = new Journey();
			journey.setJourneyId(rs.getInt(1));
			journey.setJourneyName(rs.getString(2));
			journey.setJourneyStartDate(rs.getDate(3));
			journey.setJourneyEndDate(rs.getDate(4));
			journey.setJourneyPhoto(rs.getString(5));
			journey.setIsPublic(rs.getBoolean(6));
			journey.setMemberId(rs.getInt(7));
			
			journeyList.add(journey);
			
		}
		rs.close();
		prepareStatement.close();
		
		return journeyList;
	}
	
	@Override
	public List<Journey> fuzzySearchAllJourney(String journeyName) throws SQLException {
		
		String sql = "SELECT * FROM Journey WHERE [journey_name] LIKE ?";
		
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setString(1, "%" + journeyName + "%");
		ResultSet rs = prepareStatement.executeQuery();
		
		List<Journey> journeyList = new ArrayList<>();
		
		while(rs.next()){
			Journey journey = new Journey();
			journey.setJourneyId(rs.getInt(1));
			journey.setJourneyName(rs.getString(2));
			journey.setJourneyStartDate(rs.getDate(3));
			journey.setJourneyEndDate(rs.getDate(4));
			journey.setJourneyPhoto(rs.getString(5));
			journey.setIsPublic(rs.getBoolean(6));
			journey.setMemberId(rs.getInt(7));
			
			journeyList.add(journey);
			
		}
		rs.close();
		prepareStatement.close();
		
		return journeyList;
	}

	@Override
	public List<Journey> findAllJourneyIsPublic(Boolean isPublic) throws SQLException {
		
		String sql="SELECT * FROM [ItineraryManager].[dbo].[Journey] WHERE [is_public]=1";
		
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setBoolean(1, isPublic);
		ResultSet rs = prepareStatement.executeQuery();
		
		List<Journey> journeyList = new ArrayList<>();
		
		while(rs.next()){
			Journey journey = new Journey();
			journey.setJourneyId(rs.getInt(1));
			journey.setJourneyName(rs.getString(2));
			journey.setJourneyStartDate(rs.getDate(3));
			journey.setJourneyEndDate(rs.getDate(4));
			journey.setJourneyPhoto(rs.getString(5));
			journey.setIsPublic(rs.getBoolean(6));
			journey.setMemberId(rs.getInt(7));
			
			journeyList.add(journey);
			
		}
		rs.close();
		prepareStatement.close();
		
		return journeyList;
	}

	@Override
	public List<Journey> findJourneyByMemberIdAndIsUpcoming(Integer memberId) throws SQLException {
		
		String sql="SELECT * FROM [ItineraryManager].[dbo].[Journey] WHERE [journey_end_date] > GETDATE() "
				+ "AND [fk_member_id] = ?";
		
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setInt(1, memberId);
		ResultSet rs = prepareStatement.executeQuery();
		
		List<Journey> journeyList = new ArrayList<>();
		
		while(rs.next()){
			Journey journey = new Journey();
			journey.setJourneyId(rs.getInt(1));
			journey.setJourneyName(rs.getString(2));
			journey.setJourneyStartDate(rs.getDate(3));
			journey.setJourneyEndDate(rs.getDate(4));
			journey.setJourneyPhoto(rs.getString(5));
			journey.setIsPublic(rs.getBoolean(6));
			journey.setMemberId(rs.getInt(7));
			
			journeyList.add(journey);
			
		}
		rs.close();
		prepareStatement.close();
		
		return journeyList;
	}

	@Override
	public void updateJourneyById(int journeyId) {

	}

	@Override
	public void deleteJourneyById(int journeyId) throws SQLException {
		
		String sql="DELETE FROM [ItineraryManager].[dbo].[Journey] WHERE [journey_id]=?";
		
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setInt(1, journeyId);
		
		prepareStatement.execute();
		prepareStatement.close();
	}


}
