package com.moicramsoft.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moicramsoft.entity.User;

@Repository
	public interface UserRepository extends CrudRepository<User, Long> {
	
	
	
}

