package com.csis3275.systemTest;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.sql.DataSource;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.csis3275.dao.UserRepository_Mavericks;
import com.csis3275.model.Users_Mavericks;

@DataJpaTest
class UserRepositorySystemTest {

	  @Autowired private DataSource dataSource;
	  @Autowired private JdbcTemplate jdbcTemplate;
	  @Autowired private EntityManager entityManager;
	  @Autowired private UserRepository_Mavericks userRepository;
	
	  @Test
	  void testDatabaseIsNotNull(){
	    assertNotNull(dataSource);
	    assertNotNull(jdbcTemplate);
	    assertNotNull(entityManager);
	    assertNotNull(userRepository);
	  }
	  
	  @Test
	  void testNewUser_thenFindsByName() {
	    userRepository.save(new Users_Mavericks("rita123","rita@gmail.com","Rita","Akansiima","123123123","ritapass","ritapass",false,3));
	    assertNotNull(userRepository.findByUsername("rita123"));
	  }
	  @Test 
	  void testDeleteById() {
		  userRepository.deleteById(2);
		  assertNull(userRepository.findById(2));
	  }
	  @Test
	  void testUpdateId() {
		  Users_Mavericks updateUser = userRepository.findById(2);
		  updateUser.setUsername("melanie234");
		  userRepository.save(updateUser);
		  assertEquals("melanie234",userRepository.findById(2).getUsername());
		  
	  }
	  
}
