package tw.com.nik.itinerarymanager.model.dao;

import java.sql.SQLException;
import java.util.List;

import tw.com.nik.itinerarymanager.model.bean.Journey;

public interface JourneyDAO {

	// Create
	public void createJourney(Journey journey) throws SQLException; //新增旅遊計畫

	// Read
	public Journey findJourneyById(int journeyId) throws SQLException; //顯示單個旅遊計畫
	public List<Journey> findAllJourney() throws SQLException;  //顯示某個會員與其所有的全部旅遊計畫
	public List<Journey> fuzzySearchAllJourney(String journeyName) throws SQLException;  //顯示某個會員與其所有的全部旅遊計畫
	public List<Journey> findJourneyByMemberId(int memberId) throws SQLException;  //顯示某個會員與其所有的全部旅遊計畫
	public List<Journey> findAllJourneyIsPublic(Boolean isPublic) throws SQLException;  //顯示某個會員公開的旅遊計畫
	public List<Journey> findJourneyByMemberIdAndIsUpcoming(Integer memberId) throws SQLException;  //顯示某個會員尚未開始的旅遊計畫

	// Update
	public void updateJourneyById(int journeyId) throws SQLException; // 更新旅遊計畫	

	// Delete
	public void deleteJourneyById(int journeyId) throws SQLException;  //刪除旅遊計畫
}
