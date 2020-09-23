package com.demo.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.bank.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
