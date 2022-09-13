package com.example.demo.Repository;

import com.example.demo.Model.User;
import com.example.demo.controller.user;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends MongoRepository<User, Integer> {



}
