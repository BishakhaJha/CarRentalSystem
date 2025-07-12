package com.bishakha.carrental;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bishakha.carrental.model.Car;
import com.bishakha.carrental.service.CarService;

@SpringBootTest
public class CarServiceTest {

    @Autowired
    private CarService service;

    @Test
    void testAddAndBookCar() {
        Car car = new Car("C111", "Tata Nexon");
        service.addCar(car);
        boolean booked = service.bookCar("C111");
        assertTrue(booked);
    }
}
