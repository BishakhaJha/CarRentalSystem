package com.bishakha.carrental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bishakha.carrental.model.Car;

@Service
public class CarService {
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public boolean bookCar(String id) {
        for (Car car : cars) {
            if (car.getId().equals(id) && !car.isRented()) {
                car.setRented(true);
                return true;
            }
        }
        return false;
    }

    public boolean returnCar(String id) {
        for (Car car : cars) {
            if (car.getId().equals(id) && car.isRented()) {
                car.setRented(false);
                return true;
            }
        }
        return false;
    }

    public List<Car> getAvailableCars() {
        return cars.stream().filter(c -> !c.isRented()).collect(Collectors.toList());
    }
}
