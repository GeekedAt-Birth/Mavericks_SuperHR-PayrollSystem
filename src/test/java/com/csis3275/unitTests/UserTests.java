package com.csis3275.unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.model.Users_Mavericks;

public class UserTests {
	Users_Mavericks user = new Users_Mavericks();

	@BeforeEach
	void setup() throws Exception {
		user = new Users_Mavericks("tarek", "tarek@gmail.com", "Tarek", "Ahmed", "123123123", "tarekpass", "tarekpass",
				false, 4);
	}

	@Test
	void testGetters() {
		assertEquals("tarek", user.getUsername());
		assertEquals("tarek@gmail.com", user.getEmail());
		assertEquals("Tarek", user.getFirstName());
		assertEquals("Ahmed", user.getLastName());
		assertEquals("123123123", user.getPhoneNumber());
		assertEquals("tarekpass", user.getPassword());
		assertEquals("tarekpass", user.getConfirm_password());
		assertEquals(false, user.isAdmin());
		assertEquals(4, user.getJobId());
	}
}
