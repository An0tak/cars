package com.cars.services;


import com.cars.models.Car;
import com.cars.repositories.CarRepo;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImp implements CarService{
    private CarRepo carRepo;

    public CarServiceImp(CarRepo carRepo) {
        this.carRepo = carRepo;
    }


    @Override
    public List<Car> getAll() {
        return carRepo.findAll();
    }

    @Override
    public void save(Car car) {
        carRepo.save(car);
    }

    @Override
    public Car getById(Long id) {
        return carRepo.findById(id).orElse(null);
    }

    @Override
    public List<Car> lowestPowerFirst() {
        return carRepo.findAll().stream().sorted(Comparator.comparing(Car::getPower)).collect(Collectors.toList());
    }

    @Override
    public List<Car> highestPowerFirst() {
        return carRepo.findAll().stream().sorted(Comparator.comparing(Car::getPower).reversed()).collect(Collectors.toList());
    }

    @Override
    public List<Car> cheapestFirst() {
        return carRepo.findAll().stream().sorted(Comparator.comparing(Car::getPrice)).collect(Collectors.toList());
    }

    @Override
    public List<Car> expensiveFirst() {
        return carRepo.findAll().stream().sorted(Comparator.comparing(Car::getPrice).reversed()).collect(Collectors.toList());
    }

    @Override
    public List<Car> orderByName() {
        return carRepo.findAllByMake();
    }

    @Override
    public List<Car> orderByWeightAsc() {
        return carRepo.findAllByWeightAscending();
    }

    @Override
    public List<Car> orderByWeightDesc() {
        return carRepo.findAllByWeightDescending();
    }

}
