package com.tutorial.carservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.carservice.entity.Car;

public interface ICarRepository extends JpaRepository<Car, Integer> {
    
    List<Car> findByUserId(int userId);
}
