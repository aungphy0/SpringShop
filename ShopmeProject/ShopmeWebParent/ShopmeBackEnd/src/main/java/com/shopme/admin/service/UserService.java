package com.shopme.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.admin.repositories.RoleRepository;
import com.shopme.admin.repositories.UserRepository;
import com.shopme.common.entities.Role;
import com.shopme.common.entities.User;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;


    public List<User> listAll(){
        List<User> user = (List<User>) userRepo.findAll();
        return user;
    }

    public List<Role> listRoles(){
        List<Role> role = (List<Role>) roleRepo.findAll();
        return role;
    }

    public void save(User user) {
        userRepo.save(user);
    }

}
