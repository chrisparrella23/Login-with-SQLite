package authentication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;

import utils.ConnectionUtil;

public class UserUtils {

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
	
	public static boolean userCreation(String databaseName, String[] arr, int length) {
		boolean validUser = false;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.getConnection(databaseName);
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(10);
		
			ResultSet allUsers = statement.executeQuery("SELECT * FROM Users WHERE UserName =\'" + arr[0] + "\'");
			
			if (checkLength(arr[0], length) && checkLength(arr[1], length) && checkChars(arr[1]) && isUnique(allUsers)) {
				validUser = true;
				statement.executeUpdate("INSERT INTO Users "
						+ "(UserName, Password, FirstName, LastName, Phone, Email) "
						+ "VALUES ('" + arr[0] + "', '" + arr[1] + "', '" + arr[2] + "', '" + arr[3] + "', '" + arr[4] + "', '" + arr[5] + "')");
			} else if (!checkLength(arr[0], length)) {
				System.out.println("Username must be at least 6 characters long.");
				validUser = false;
			} else if (!checkLength(arr[1], length)) {
				System.out.println("Password must be at least 6 characters long.");
				validUser = false;
			} else if (!checkChars(arr[1])) {
				System.out.println("Password must contain at least 1 uppercase letter,"
						+ " 1 lowercase letter, and 1 digit.");
				validUser = false;
			} else if (!isUnique(allUsers)) {
				System.out.println("Username already exists. Please try another username.");
				validUser = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(connection);
		}
		return validUser;
	}
	
	public static boolean checkLength(String str, int length) {
		if (str.length() >= length) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isUnique(ResultSet rs) {
		try {
			if (rs.isAfterLast()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean checkChars(String str) {
		char ch;
		boolean hasUpper = false;
		boolean hasLower = false;
		boolean hasDigit = false;
		
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (Character.isUpperCase(ch)) {
				hasUpper = true;
			} else if (Character.isLowerCase(ch)) {
				hasLower = true;
			} else if (Character.isDigit(ch)) {
				hasDigit = true;
			}
		}
		
		if (hasUpper && hasLower && hasDigit) {
			return true;
		}
		return false;
	}
	
	public static boolean changePassword(String databaseName, String username, String newPassword) {
		boolean validNewPassword = false;
		
		Connection connection = null;
		
		try {
			connection = ConnectionUtil.getConnection(databaseName);
			
			if (!checkLength(newPassword, 6) || (!checkChars(newPassword))) {
				System.out.println("Not a valid password. Password must be at least"
						+ " 6 characters long and contain at least 1 uppercase letter,"
						+ " 1 lowercase letter, and 1 digit.");
				validNewPassword = false;
			} else {
				validNewPassword = true;
				
				String updateString = "UPDATE Users " + "SET Password = ? WHERE Username = ?";
				PreparedStatement pst = connection.prepareStatement(updateString);
				
				pst.setString(1, newPassword);
				pst.setString(2, username);
				pst.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(connection);
		}
		return validNewPassword;
	}
}
