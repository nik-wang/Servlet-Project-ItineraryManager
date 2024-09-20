package tw.com.nik.itinerarymanager.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tw.com.nik.itinerarymanager.model.bean.Member;

public class MemberDAOImpl implements MemberDAO {

	private Connection conn;

	public MemberDAOImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void createMember(Member member) throws SQLException {

		String sql = "INSERT INTO[ItineraryManager].[dbo].[Member]([member_account]" + ",[member_password]"
				+ ",[member_name]" + ",[member_age]" + ",[member_photo])" + "VALUES(?,?,?,?,?)";
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setString(1, member.getMemberAccount());
		prepareStatement.setString(2, member.getMemberPassword());
		prepareStatement.setString(3, member.getMemberName());

		if (member.getMemberAge() == null) {
			prepareStatement.setNull(4, java.sql.Types.INTEGER);
		} else {
			prepareStatement.setInt(4, member.getMemberAge());
		}

		if (member.getMemberPhoto() == null) {
			prepareStatement.setNull(5, java.sql.Types.VARCHAR);
		} else {
			prepareStatement.setString(5, member.getMemberPhoto());
		}

		prepareStatement.execute();
		prepareStatement.close();
	}

	@Override
	public Member findMemberById(int memberId) throws SQLException {

		String sql = "SELECT * FROM [ItineraryManager].[dbo].[Member] WHERE [member_id] =?";
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setInt(1, memberId);

		ResultSet rs = prepareStatement.executeQuery();

		if (rs.next()) {
			Member member = new Member();
			member.setMemberId(rs.getInt(1));
			member.setMemberAccount(rs.getString(2));
			member.setMemberPassword(rs.getString(3));
			member.setMemberName(rs.getString(4));
			member.setMemberAge(rs.getInt(5));
			member.setMemberPhoto(rs.getString(6));

			return member;
		}

		rs.close();
		prepareStatement.close();

		return null;
	}

	@Override
	public Member findMemberByAccountAndPassword(String memberAccount, String memberPassword) throws SQLException {

		String sql = "SELECT * FROM [ItineraryManager].[dbo].[Member] WHERE [member_account] COLLATE Latin1_General_CS_AS = ? AND [member_password] COLLATE Latin1_General_CS_AS = ?";
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		prepareStatement.setString(1, memberAccount);
		prepareStatement.setString(2, memberPassword);

		ResultSet rs = prepareStatement.executeQuery();

		if (rs.next()) {
			Member member = new Member();
			member.setMemberId(rs.getInt(1));
			member.setMemberAccount(rs.getString(2));
			member.setMemberPassword(rs.getString(3));
			member.setMemberName(rs.getString(4));
			member.setMemberAge(rs.getInt(5));
			member.setMemberPhoto(rs.getString(6));

			return member;
		}

		rs.close();
		prepareStatement.close();

		return null;
	}

	@Override
	public void updateMemberDetailsById(Member member) throws SQLException {

		String sql = "UPDATE [ItineraryManager].[dbo].[Member] " + "SET [member_account] = ?," + "[member_password]= ?,"
				+ "[member_name]=?," + "[member_age]=?" + " WHERE [member_id] =?";
		PreparedStatement prepareStatement = conn.prepareStatement(sql);

		prepareStatement.setString(1, member.getMemberAccount());
		prepareStatement.setString(2, member.getMemberPassword());
		prepareStatement.setString(3, member.getMemberName());

		if (member.getMemberAge() == null) {
			prepareStatement.setNull(4, java.sql.Types.INTEGER);
		} else {
			prepareStatement.setInt(4, member.getMemberAge());
		}

		prepareStatement.setInt(5, member.getMemberId());

		prepareStatement.execute();
		prepareStatement.close();

	}

	@Override
	public void updateMemberPhotoById(Member member) throws SQLException {
		String sql = "UPDATE [ItineraryManager].[dbo].[Member] " + "SET [member_photo]=?" + " WHERE [member_id] =?";

		PreparedStatement prepareStatement = conn.prepareStatement(sql);

		if (member.getMemberPhoto() == null) {
			prepareStatement.setNull(1, java.sql.Types.VARCHAR);
		} else {
			prepareStatement.setString(1, member.getMemberPhoto());
		}
		
		prepareStatement.setInt(2, member.getMemberId());
		
		prepareStatement.execute();
		prepareStatement.close();

	}

	@Override
	public void deleteMemberById(int memberId) throws SQLException {

		String sql = "DELETE FROM [ItineraryManager].[dbo].[Member] WHERE [member_id] =?";
		PreparedStatement prepareStatement = conn.prepareStatement(sql);

		prepareStatement.setInt(1, memberId);

		prepareStatement.execute();
		prepareStatement.close();

	}

}
