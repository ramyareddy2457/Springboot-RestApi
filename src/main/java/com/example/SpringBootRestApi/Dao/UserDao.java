package com.example.SpringBootRestApi.Dao;

import com.example.SpringBootRestApi.Entity.Users;
import com.example.SpringBootRestApi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    //  save the users
    public Users save(Users u) {
        return userRepository.save(u);
    }

    //    get all users
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    //    get a employee through id;
   public Users findById(int id){
        return userRepository.findById(id);
   }

//    delete a employee
    public void delete(Users u){
        userRepository.delete(u);
    }


}
