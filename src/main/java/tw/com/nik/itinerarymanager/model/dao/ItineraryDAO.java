package tw.com.nik.itinerarymanager.model.dao;

import java.sql.SQLException;
import java.util.List;

import tw.com.nik.itinerarymanager.model.bean.Itinerary;

public interface ItineraryDAO {
	
	//Create
	public void createItinerary(Itinerary itinerary) throws SQLException;  //新增行程
	
	//Read
	public Itinerary findItineraryById(int itineraryId) throws SQLException;  //顯示某個行程
	public List<Itinerary> findItineraryByJourneyId(int journeyId) throws SQLException;  //顯示一個旅遊計畫底下的所有行程
	public List<Itinerary> findItineraryByJourneyIdAndIfChecked(int journeyId, Boolean ifChecked) throws SQLException; //顯示同一個旅遊計畫中有完成的行程
	
	//Update
	public void updateItineraryById(int itineraryId) throws SQLException;  //更新行程
	
	//Delete
	public void deleteItineraryById(int itineraryId) throws SQLException;  //刪除行程

}
