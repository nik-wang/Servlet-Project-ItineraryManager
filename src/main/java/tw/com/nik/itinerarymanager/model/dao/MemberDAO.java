package tw.com.nik.itinerarymanager.model.dao;

import java.sql.SQLException;

import tw.com.nik.itinerarymanager.model.bean.Member;

public interface MemberDAO {
	
	//Create
	public void createMember(Member member) throws SQLException;  //註冊
	
	//Read
	public Member findMemberById(int memberId) throws SQLException;   //顯示個人資料
	public Member findMemberByAccountAndPassword(String memberAccount, String memberPassword) throws SQLException;   //登入
	
	//Update
	public void updateMemberDetailsById(Member member) throws SQLException;  //更新個人資料
	public void updateMemberPhotoById(Member member) throws SQLException;  //更新個人大頭照
	
	//Delete
	public void deleteMemberById(int memberId) throws SQLException;  //刪除
}
