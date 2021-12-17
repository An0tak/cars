package com.cars.services;

import com.cars.models.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();
    void save(Car car);
    Car getById(Long id);
    List<Car>lowestPowerFirst();
    List<Car>highestPowerFirst();
    List<Car>cheapestFirst();
    List<Car>expensiveFirst();
    List<Car>orderByName();
    List<Car>orderByWeightAsc();
    List<Car>orderByWeightDesc();
}
