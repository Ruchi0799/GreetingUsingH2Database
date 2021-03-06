package com.spring.databaseGreeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.databaseGreeting.entity.Customer;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer, Long> {

}
