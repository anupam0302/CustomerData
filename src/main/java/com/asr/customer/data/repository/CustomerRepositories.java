package com.asr.customer.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asr.customer.data.model.Customer;

public interface CustomerRepositories extends JpaRepository<Customer, Integer> {

}
