package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import authentication.User;
import authentication.UserUtils;
import utils.ConnectionUtil;

public class LoginTest {

	@Test
	public void successTest() {
		String[] loginInfo = UserUtils.getLoginInfo("jsmith", "password123");
		String[] userInfo = UserUtils.login("UserDB.sqlite", loginInfo);
		for (int i = 0; i < userInfo.length; i++) {
			System.out.println(userInfo[i]);
		}
		
		assertEquals(userInfo[0], loginInfo[0]);
		assertEquals(userInfo[1], loginInfo[1]);
	}

	@Test
	public void failureTest() {
		String[] loginInfo = UserUtils.getLoginInfo("zjohnson", "password456");
		String[] userInfo = UserUtils.login("UserDB.sqlite", loginInfo);
		for (int i = 0; i < userInfo.length; i++) {
			System.out.println(userInfo[i]);
		}
		
		assertEquals(userInfo[0], loginInfo[0]);
		assertEquals(userInfo[1], loginInfo[1]);
	}

}
