package com.csis3275.unitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.model.Pay_Mavericks;

public class PayTests {
	Pay_Mavericks payStub;
	Date startDate;
	Date endDate;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		startDate = new Date(120, 10, 1);
		endDate = new Date(120, 10, 14);
		payStub = new Pay_Mavericks(10,15,startDate,endDate,1, false,123);
	}
	@Test
	void testBenefitEI() {
		assertEquals(0.0158,payStub.getBenefitEI(), 0.0f);
	}
	@Test
	void testBenefitCPP() {
		assertEquals(0.0525,payStub.getBenefitCPP(), 0.0f);
	}
	@Test
	void testIncomeTax() {
		assertEquals(0.15,payStub.getIncomeTax(), 0.0f);
	}

	@Test
	void testSickDays() {
		assertEquals(10,payStub.getSickDays());
	}
	@Test
	void testHoliDays() {
		assertEquals(15,payStub.getHolidays());
	}

	
	@Test
	void testEmployeeID() {
		assertEquals(1,payStub.getEmployeeID());
	}
	
	@Test
	void testPayStatus() {
		assertFalse(payStub.isPayStatus());
	}
}
