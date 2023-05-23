package com.tutorial.bikeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.bikeservice.entity.Bike;

public interface IBikeRepository extends JpaRepository<Bike, Integer> {
    
    List<Bike> findByUserId(int userId);
}
