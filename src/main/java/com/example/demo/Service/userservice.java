package com.example.demo.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userservice {
    private final userRepo userpo;
     @Autowired
    public userservice(userRepo userpo) {
        this.userpo = userpo;
    }
    public void addus(User use) {
         userpo.save(use);
    }

    public List<User> findAll() {
      return   userpo.findAll();
    }

    public int findpar(int id) {
         User user1=userpo.findById(id).orElse(null);
         if(user1==null)
             return 0;
         return  user1.getId();
    }

    public int deleteuse(int id) {
         User userrr=userpo.findById(id).orElse(null);
         if(userrr==null){
             return 0;
         }
         userpo.delete(userrr);
        return 1;
    }
    public User updatede(int id, User use1) {
         User user2=userpo.findById(id).orElse(null);
         if(user2==null){
             return new User(use1.getId(), use1.getName(), use1.getAge(), use1.getSalary());
         }
         user2.setId(use1.getId());
         user2.setName(use1.getName());
         user2.setAge(use1.getAge());
         user2.setSalary(use1.getSalary());
         userpo.save(user2);
        return user2;
    }
}
