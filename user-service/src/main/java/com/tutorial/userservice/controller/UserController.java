package com.tutorial.userservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.userservice.entity.User;
import com.tutorial.userservice.model.Bike;
import com.tutorial.userservice.model.Car;
import com.tutorial.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAll();
        if(users.isEmpty()) 
            return ResponseEntity.noContent().build();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        if(user == null) 
            return ResponseEntity.noContent().build();
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User userNew = userService.save(user);
        if(userNew == null) 
            return ResponseEntity.noContent().build();
        return new ResponseEntity<User>(userNew, HttpStatus.OK);
    }

    @GetMapping("/cars/{userId}")
    public ResponseEntity<List<Car>> getCars(@PathVariable("userId") int userId) {
        User user = userService.getUserById(userId);
        if(user == null) 
            return ResponseEntity.noContent().build();
        List<Car> cars = userService.getCars(userId);
        return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
    }

    @GetMapping("/bikes/{userId}")
    public ResponseEntity<List<Bike>> getBikes(@PathVariable("userId") int userId) {
        User user = userService.getUserById(userId);
        if(user == null) 
            return ResponseEntity.noContent().build();
        List<Bike> bikes = userService.getBikes(userId);
        return new ResponseEntity<List<Bike>>(bikes, HttpStatus.OK);
    }

    @PostMapping("/carsave/{userId}")
    public ResponseEntity<Car> saveCar(@PathVariable("userId") int userId, @RequestBody Car car) {
        User user = userService.getUserById(userId);
        if(user == null) 
            return ResponseEntity.noContent().build();
        Car newCar = userService.saveCar(userId, car);
        return new ResponseEntity<Car>(newCar, HttpStatus.OK);
    }

    @PostMapping("/bikesave/{userId}")
    public ResponseEntity<Bike> saveBike(@PathVariable("userId") int userId, @RequestBody Bike bike) {
        User user = userService.getUserById(userId);
        if(user == null) 
            return ResponseEntity.noContent().build();
        Bike newBike = userService.saveBike(userId, bike);
        return new ResponseEntity<Bike>(newBike, HttpStatus.OK);
    }

    @GetMapping("/getAll/{userId}")
    public ResponseEntity<Map<String, Object>> getAllVehicles(@PathVariable("userId") int userId) {
        Map<String, Object> result = userService.getUserAndVehicles(userId);
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }
}
