package com.shopme.admin.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopme.common.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	

}
