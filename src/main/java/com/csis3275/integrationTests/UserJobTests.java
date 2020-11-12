package com.csis3275.integrationTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.csis3275.dao.JobsRepository_Mavericks;
import com.csis3275.model.Jobs_Mavericks;
import com.csis3275.model.Users_Mavericks;

@DataJpaTest
public class UserJobTests {
	Users_Mavericks user = new Users_Mavericks();
	Jobs_Mavericks job = new Jobs_Mavericks();
	
	@Autowired
	JobsRepository_Mavericks jobRepo;
	
	@BeforeEach
	void setup() throws Exception {
		user = new Users_Mavericks("tarek", "tarek@gmail.com", "Tarek", "Ahmed", "123123123", "tarekpass", "tarekpass",false, 3);
	}
	
	@Test
	void checkUserJobConnection() {
		Jobs_Mavericks job = jobRepo.findById(user.getJobId());
//		System.out.println(job);
		assertEquals("SOFTWARE ARCHITECT", job.getTitle());
		assertNotEquals("SOFTWARE ENGINEER II", job.getTitle());
	}
}
