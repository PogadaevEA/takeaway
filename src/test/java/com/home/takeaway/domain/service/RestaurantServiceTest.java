package com.home.takeaway.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class RestaurantServiceTest {

    @Test
    @DisplayName("Bla bla")
    public void getRestaurantList() {
        Assertions.assertEquals("","");
    }
}