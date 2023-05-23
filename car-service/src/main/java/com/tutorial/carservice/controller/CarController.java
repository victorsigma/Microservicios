package com.tutorial.carservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.carservice.entity.Car;
import com.tutorial.carservice.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAll() {
        List<Car> cars = carService.getAll();
        if(cars.isEmpty()) 
            return ResponseEntity.noContent().build();
        return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable("id") int id) {
        Car car = carService.getCarById(id);
        if(car == null) 
            return ResponseEntity.noContent().build();
        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car) {
        Car carNew = carService.save(car);
        if(carNew == null) 
            return ResponseEntity.noContent().build();
        return new ResponseEntity<Car>(carNew, HttpStatus.OK);
    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Car>> getByUserId(@PathVariable("userId") int userId) {
        List<Car> cars = carService.byUserId(userId);
        if(cars.isEmpty()) 
            return ResponseEntity.noContent().build();
        return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
    }
}
