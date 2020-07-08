package com.damo.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.damo.rest.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
