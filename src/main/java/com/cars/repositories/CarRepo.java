package com.cars.repositories;

import com.cars.models.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends CrudRepository<Car, Long> {

    List<Car> findAll();

    @Query(value = "Select * from car order by make", nativeQuery = true)
    List<Car> findAllByMake();

    @Query(value = "Select * from car order by weight", nativeQuery = true)
    List<Car> findAllByWeightAscending();

    @Query(value = "Select * from car order by weight DESC", nativeQuery = true)
    List<Car> findAllByWeightDescending();

}
