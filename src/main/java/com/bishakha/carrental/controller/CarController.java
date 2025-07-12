package com.bishakha.carrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bishakha.carrental.model.Car;
import com.bishakha.carrental.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public ResponseEntity<String> addCar(@RequestBody Car car) {
        carService.addCar(car);
        return ResponseEntity.ok("Car added successfully!");
    }

    @PostMapping("/book/{id}")
    public ResponseEntity<String> bookCar(@PathVariable String id) {
        boolean success = carService.bookCar(id);
        return success ? ResponseEntity.ok("Car booked successfully!") :
                ResponseEntity.badRequest().body("Car not available!");
    }

    @PostMapping("/return/{id}")
    public ResponseEntity<String> returnCar(@PathVariable String id) {
        boolean success = carService.returnCar(id);
        return success ? ResponseEntity.ok("Car returned successfully!") :
                ResponseEntity.badRequest().body("Car not rented or not found!");
    }

    @GetMapping("/available")
    public ResponseEntity<List<Car>> getAvailableCars() {
        return ResponseEntity.ok(carService.getAvailableCars());
    }
}
