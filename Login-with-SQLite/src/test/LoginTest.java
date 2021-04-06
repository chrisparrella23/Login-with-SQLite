package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import authentication.User;
import utils.ConnectionUtil;

public class LoginTest {

	@Test
	public void successTest() {
		User u1 = new User("jsmith", "password123", "John", "Smith", "5556789", "jsmith@gmail.com");

		Connection connection = null;

		try {
			connection = ConnectionUtil.getConnection("UserDB.sqlite");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(10);
			statement.executeUpdate("DROP TABLE IF EXISTS Users");

			statement.executeUpdate(
					"CREATE TABLE Users " + "(UserName NOT NULL UNIQUE," 
							+ "Password VARCHAR(50) NOT NULL,"
							+ "FirstName VARCHAR(50) NOT NULL," 
							+ "LastName VARCHAR(50) NOT NULL,"
							+ "Phone VARCHAR(50) NOT NULL," 
							+ "Email VARCHAR(50) NOT NULL" + ")");

			statement.executeUpdate("INSERT INTO Users "
					+ "(UserName, Password, FirstName, LastName, Phone, Email)"
					+ "VALUES ('jsmith', 'password123', 'John', 'Smith', '5556789', 'jsmith@gmail.com')");

			statement.executeUpdate("INSERT INTO Users " 
					+ "(UserName, Password, FirstName, LastName, Phone, Email)"
					+ "VALUES ('ztaylor', 'password456', 'Zack', 'Taylor', '5556789', 'ztaylor@gmail.com')");

			ResultSet rs = statement.executeQuery("SELECT * FROM Users");

			assertEquals(rs.getString("UserName"), u1.getUsername());
			assertEquals(rs.getString("Password"), u1.getPassword());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(connection);
		}

	}

	@Test
	public void failureTest() {
		User u1 = new User("ztaylor", "password456", "Zack", "Taylor", "5556789", "ztaylor@gmail.com");

		Connection connection = null;

		try {
			connection = ConnectionUtil.getConnection("UserDB.sqlite");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(10);
			statement.executeUpdate("DROP TABLE IF EXISTS Users");

			statement.executeUpdate(
					"CREATE TABLE Users " 
						+ "(UserName NOT NULL UNIQUE," 
						+ "Password VARCHAR(50) NOT NULL,"
						+ "FirstName VARCHAR(50) NOT NULL," + "LastName VARCHAR(50) NOT NULL,"
						+ "Phone VARCHAR(50) NOT NULL," + "Email VARCHAR(50) NOT NULL" + ")");

			statement.executeUpdate("INSERT INTO Users " 
					+ "(UserName, Password, FirstName, LastName, Phone, Email)"
					+ "VALUES ('jsmith', 'password123', 'John', 'Smith', '5556789', 'jsmith@gmail.com')");

			statement.executeUpdate("INSERT INTO Users " 
					+ "(UserName, Password, FirstName, LastName, Phone, Email)"
					+ "VALUES ('ztaylor', 'password456', 'Zack', 'Taylor', '5556789', 'ztaylor@gmail.com')");

			ResultSet rs = statement.executeQuery("SELECT * FROM Users");

			assertEquals(rs.getString("UserName"), u1.getUsername());
			assertEquals(rs.getString("Password"), u1.getPassword());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnection(connection);
		}
	}

}
