package tw.com.nik.itinerarymanager.init;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import tw.com.nik.itinerarymanager.model.bean.Member;
import tw.com.nik.itinerarymanager.util.ConnectionFactory;

@WebListener
public class Initialization implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		ServletContext context = sce.getServletContext();

		context.setAttribute("root", context.getContextPath());
		context.setAttribute("webName", "Itinerary Manager");
		context.setAttribute("external", "external-resources/");

		try (Connection conn = ConnectionFactory.getConnection()) {

			createDB(conn);
			createTableAndInsertData(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void createDB(Connection conn) throws SQLException {

		String sql = "IF DB_ID('ItineraryManager') IS NULL CREATE DATABASE ItineraryManager";

		Statement createStatement = conn.createStatement();

		createStatement.execute(sql);
		createStatement.close();
	}

	private void createTableAndInsertData(Connection conn) throws Exception {

//		// 初始化Member表格
		String sql = "IF OBJECT_ID('[ItineraryManager].[dbo].[Member]') IS NULL "
				+ "CREATE TABLE [ItineraryManager].[dbo].[Member](" + "member_id INT PRIMARY KEY IDENTITY(1,1),"
				+ "member_account NVARCHAR(50) NOT NULL UNIQUE," + "member_password NVARCHAR(50) NOT NULL,"
				+ "member_name NVARCHAR(50) NOT NULL," + "member_age INT ," + "member_photo NVARCHAR(MAX)"
				+ ");";

		Statement createStatement = conn.createStatement();

		createStatement.execute(sql);
		createStatement.close();

		// 初始化Journey表格
		sql = "IF OBJECT_ID('[ItineraryManager].[dbo].[Journey]') IS NULL "
				+ "CREATE TABLE [ItineraryManager].[dbo].[Journey](" + "journey_id INT PRIMARY KEY IDENTITY(1,1),"
				+ "journey_name NVARCHAR(50)," + "journey_start_date DATE," + "journey_end_date DATE,"
				+ "journey_photo NVARCHAR(MAX)," + "is_public BIT," + "fk_member_id INT,"
				+ "FOREIGN KEY(fk_member_id) REFERENCES [ItineraryManager].[dbo].[Member](member_id)" + ")";

		createStatement = conn.createStatement();

		createStatement.execute(sql);
		createStatement.close();

		// 初始化Itinerary表格
		sql = "IF OBJECT_ID('[ItineraryManager].[dbo].[Itinerary]') IS NULL "
				+ "CREATE TABLE [ItineraryManager].[dbo].[Itinerary](" + " itinerary_id INT PRIMARY KEY IDENTITY(1,1),"
				+ "itinerary_start_date DATE ," + "itinerary_end_date DATE ," + "itinerary_start_time TIME ,"
				+ "itinerary_end_time TIME ," + "[name] NVARCHAR(225)," + "destination NVARCHAR(MAX) NOT NULL,"
				+ "[URL] NVARCHAR(MAX)," + "category NVARCHAR(100)," + "[description] NVARCHAR(225),"
				+ "note NVARCHAR(225)," + "budget INT," + "is_paid BIT," + "is_checked BIT," + "fk_journey_id INT,"
				+ "FOREIGN KEY(fk_journey_id) REFERENCES [ItineraryManager].[dbo].[Journey](journey_id)" + ")";

		createStatement = conn.createStatement();

		createStatement.execute(sql);
		createStatement.close();

		// 初始化Member資料
//		sql = "SELECT [member_id] FROM [ItineraryManager].[dbo].[Member]";
//		if (!conn.createStatement().executeQuery(sql).next()) {
//
//			BufferedReader br = new BufferedReader(new FileReader("/Users/nicole/Desktop/iSpan/midterm project/TestMember.json"));
//			Type listType = new TypeToken<List<Member>>() {}.getType();
//	        List<Member> members = new Gson().fromJson(br, listType);
//	        
//	        System.out.println(members);
//	        
//	        br.close();

//			String sql = "INSERT INTO [ItineraryManager].[dbo].[Member]"
//					+ "([member_account],[member_password],[member_name],[member_age])"
//					+ "VALUES (?,?,?,?)";
//			
//			PreparedStatement prepareStatement = conn.prepareStatement(sql);
//			
//			for(Member member: members) {
//				prepareStatement.setString(1,member.getMemberAccount());
//				prepareStatement.setString(2,member.getMemberPassword());
//				prepareStatement.setString(3,member.getMemberName());
//				prepareStatement.setObject(4,member.getMemberAge(),java.sql.Types.INTEGER);
//			
//				BufferedInputStream bis= new BufferedInputStream(new FileInputStream("/Users/nicole/Desktop/iSpan/midterm project/members/"+member.getMemberName()+ ".jpg"));
//				byte[] memberPhotoBytes = bis.readAllBytes();
//				String memberBase64Photo ="data:image/png;base64," + Base64.getEncoder().encodeToString(memberPhotoBytes);
//				
//				prepareStatement.setString(5,memberBase64Photo);
//				prepareStatement.addBatch();				
//				
//			}
//			prepareStatement.executeBatch();
//			prepareStatement.close();

//		}

	}

}
