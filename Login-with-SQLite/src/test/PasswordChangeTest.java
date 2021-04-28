package test;

import static org.junit.Assert.*;

import org.junit.Test;

import authentication.UserUtils;

public class PasswordChangeTest {

	@Test
	public void passwordChangeTestSuccess() {
		// password change method could return a boolean
		// method needs to:
		// take string for new password
		// open connection (EZ PZ)
		// use UPDATE method to change password with username as 
		// WHERE condition (EZ PZ)
		// close connection
		assertTrue(UserUtils.changePassword("UserDB.sqlite", "agustafson", "Wiley890"));
	}
	
	@Test
	public void passwordChangeTestFail() {
		assertTrue(UserUtils.changePassword("UserDB.sqlite", "agustafson", "ey890"));
	}

}
