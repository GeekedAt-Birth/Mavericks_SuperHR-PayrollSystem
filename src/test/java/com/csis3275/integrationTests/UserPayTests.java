package com.csis3275.integrationTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.csis3275.dao.PayrollDao_Mavericks;
import com.csis3275.dao.UserRepository_Mavericks;
import com.csis3275.model.Pay_Mavericks;
import com.csis3275.model.Users_Mavericks;

@DataJpaTest
public class UserPayTests {
    Users_Mavericks user = new Users_Mavericks();
    Pay_Mavericks pay = new Pay_Mavericks();

    @Autowired
    PayrollDao_Mavericks payRepo;

    @Autowired
    UserRepository_Mavericks userRepo;

    @BeforeEach
    void setup() {
        
    }

    @Test
    void checkUserPayConnection() {
        Users_Mavericks newUser = userRepo.findByUsername("melanie");
        Pay_Mavericks pay = payRepo.findByEmployeeID(newUser.getId());
        assertEquals(15, pay.getHolidays());
    }
    
    @Test
    void checkUserPayConnection2() {
    	user = new Users_Mavericks("tarek", "tarek@gmail.com", "Tarek", "Ahmed", "123123123", "tarekpass", "tarekpass",false, 3);
        pay = new Pay_Mavericks(7, 10, new Date(), new Date(), 4, true,1234);
        
        Users_Mavericks newUser = userRepo.findByUsername(user.getUsername());
        Pay_Mavericks pay = payRepo.findByEmployeeID(newUser.getId());
        assertEquals(10, pay.getHolidays());
    }
}
