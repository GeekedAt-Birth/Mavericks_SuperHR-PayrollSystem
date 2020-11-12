package com.csis3275.unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.model.Jobs_Mavericks;

public class JobsTests {
	Jobs_Mavericks job = new Jobs_Mavericks();
	
	@BeforeEach
	void setup() throws Exception {
		job = new Jobs_Mavericks("SOFTWARE DEVELOPER", 250.0, 10);
	}	
	
	@Test
	void testTitle() {
		assertEquals("SOFTWARE DEVELOPER", job.getTitle());
	}
	
	@Test
	void testSalary() {
		assertEquals(250.0, job.getSalaryPerDay(), 0.0f);		
	}
	
	@Test
	void testPayPeriod() {
		assertEquals(10, job.getPayPeriod());
	}
}
