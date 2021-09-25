package com.spring.databaseGreeting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.databaseGreeting.entity.Customer;
import com.spring.databaseGreeting.repository.ICustomerRepo;

@RestController
public class CustomerController {
	@Autowired
	ICustomerRepo customerRepo;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> save(@RequestBody Customer customer){
		try {
		return new ResponseEntity<>(customerRepo.save(customer),HttpStatus.CREATED);	
	}catch(Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		try {
			List<Customer> list = customerRepo.findAll();
			if(list.isEmpty() || list.size()==0) {
				return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
				
			}
			return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			// TODO: handle exception
		}
		
	}
	
	

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getSingleCustomers(@PathVariable Long id){
		Optional<Customer> customer=customerRepo.findById(id);
		if(customer.isPresent()) {
			return new ResponseEntity<Customer>(customer.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}
}
