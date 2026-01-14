package com.thejus.brown.JobRESTApp.repository;

import com.thejus.brown.JobRESTApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
