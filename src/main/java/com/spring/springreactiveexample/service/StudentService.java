package com.spring.springreactiveexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springreactiveexample.dao.StudentRepository;
import com.spring.springreactiveexample.model.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Mono<Student> saveStudent(Student student) {

		return studentRepository.save(student);
	}

	public Mono<Student> getStudent(int id) {

		return studentRepository.findById(id);
	}
	
	public Flux<Student> getAllStudent()
	{
		return studentRepository.findAll();
	}
	
	public Mono<Void> deleteStudent(int id) {

		return studentRepository.deleteById(id);
	}
	
	public Mono<Student> updateStudent(int id,Student student) {

		return studentRepository.findById(id).map(s-> {
												s.setFirstName(student.getFirstName());
												s.setLastName(student.getLastName());
												return s;
												}).flatMap(s->studentRepository.save(s));
	}

}
