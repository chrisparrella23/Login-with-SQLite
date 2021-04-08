package authentication;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import utils.ConnectionUtil;

public class LoginUtils {

	public static String[] login(String databaseName, String[] info) {
		
		Connection connection = null;
		String username = info[0];
		String password = info[1];
		
		try {
			connection = ConnectionUtil.getConnection(databaseName);
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(10);

			ResultSet rs = statement.executeQuery("SELECT * FROM Users WHERE UserName =\'" + username + "\' AND Password =\'" + password + "\'");
			String[] userInfo = new String[6];
			
			if (rs.isAfterLast()) {
				System.out.println("No users were found! Check your login details.");
			} else {
				userInfo[0] = rs.getString("UserName");
				userInfo[1] = rs.getString("Password");
				userInfo[2] = rs.getString("FirstName");
				userInfo[3] = rs.getString("LastName");
				userInfo[4] = rs.getString("Phone");
				userInfo[5] = rs.getString("Email");
			}
			
			return userInfo;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(connection);
		}
		return null;
	}
	
	public static String[] getLoginInfo(String username, String password) {
		String[] info = new String[2];
		info[0] = username;
		info[1] = password;
		return info;
	}
}
