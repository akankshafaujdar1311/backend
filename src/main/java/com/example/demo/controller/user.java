package com.example.demo.controller;
import com.example.demo.Model.User;
import com.example.demo.Service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class user {
    @Autowired
    public userservice us;
    @PostMapping("/user")
    public void adduser(@RequestBody User use){
        us.addus(use);
    }
    @GetMapping(value="/userdetails")
    public List<User> getuserdetails(){
        return us.findAll();
    }
    @DeleteMapping(value="/user/{id}")
    public ResponseEntity<Integer> deleteuser(@PathVariable int id)
    {
        int response=us.deleteuse(id);
        if(response==0){
            return new ResponseEntity<>(1, HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping(value = "/userdetail/{id}")
    public int  getpartiuser(@PathVariable int id){
        return us.findpar(id);
    }
    @PutMapping(value="/update/{id}")
    public ResponseEntity<User> updated(@PathVariable int id,@RequestBody User use1){
        User user2=us.updatede(id,use1);
        return new ResponseEntity<>(user2,HttpStatus.OK);
    }
}
