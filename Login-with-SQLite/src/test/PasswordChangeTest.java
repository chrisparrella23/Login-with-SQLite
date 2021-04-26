package test;

import static org.junit.Assert.*;

import org.junit.Test;

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
		assertTrue(changePassword(String username, String newPassword));
		fail("Not yet implemented");
	}
	
	@Test
	public void passwordChangeTestFail() {
		
		fail("Not yet implemented");
	}

}
