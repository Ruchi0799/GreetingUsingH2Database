package com.spring.databaseGreeting.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="tbl_customer")
@Entity
@Setter
@Getter
//@ToString
public class Customer {
	
	@Override
	public String toString() {
		return "Hello  [id=" + id + ", name=" + name + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
