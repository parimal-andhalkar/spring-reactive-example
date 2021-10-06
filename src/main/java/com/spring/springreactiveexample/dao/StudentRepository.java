package com.spring.springreactiveexample.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.springreactiveexample.model.Student;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<Student, Integer> {
	
}
