package test;

import static org.junit.Assert.*;

import org.junit.Test;

import authentication.UserUtils;

public class UserCreationTest {

	@Test
	public void userCreationTest1() {
		String[] arr1 = {"wgustafson", "Wiley123", "Wiley", "Gustafson", "2549990", "wgust@yahoo.com"};
		assertTrue(UserUtils.userCreation("UserDB.sqlite", arr1, 6));
	}
	
	@Test
	public void userCreationTest2() {
		String[] arr2 = {"wgus", "Wiley123", "Wiley", "Gustafson", "2549990", "wgust@yahoo.com"};
		assertTrue(UserUtils.userCreation("UserDB.sqlite", arr2, 6));
	}
	
	@Test
	public void userCreationTest3() {
		String[] arr3 = {"wgustafson", "Wy123", "Wiley", "Gustafson", "2549990", "wgust@yahoo.com"};
		assertTrue(UserUtils.userCreation("UserDB.sqlite", arr3, 6));
	}
	
	@Test
	public void userCreationTest4() {
		String[] arr4 = {"wgustafson", "wiley123", "Wiley", "Gustafson", "2549990", "wgust@yahoo.com"};
		assertTrue(UserUtils.userCreation("UserDB.sqlite", arr4, 6));
	}
	
	@Test
	public void userCreationTest5() {
		String[] arr5 = {"wgustafson", "Wiley123", "Wiley", "Gustafson", "2549990", "wgust@yahoo.com"};
		assertTrue(UserUtils.userCreation("UserDB.sqlite", arr5, 6));
	}

}
