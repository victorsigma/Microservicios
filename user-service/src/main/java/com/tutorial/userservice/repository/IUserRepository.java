package com.tutorial.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.userservice.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
    
}
