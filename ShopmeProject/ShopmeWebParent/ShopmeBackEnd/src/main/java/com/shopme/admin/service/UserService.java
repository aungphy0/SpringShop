package com.shopme.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.admin.repositories.UserRepository;
import com.shopme.common.entities.User;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repo;


    public List<User> listAll(){
        List<User> user = (List<User>) repo.findAll();
        return user;
    }

}
