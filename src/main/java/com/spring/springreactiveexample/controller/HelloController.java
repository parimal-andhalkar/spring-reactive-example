package com.spring.springreactiveexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.springreactiveexample.model.Student;
import com.spring.springreactiveexample.service.StudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactive")
public class HelloController {

	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/get/{id}")
	public Mono<Student> getStudent(@PathVariable("id") int id) {
				
		return studentService.getStudent(id);
	}
	
	@PostMapping("/register")
	public Mono<Student> saveStudent(@RequestBody Student student) {
				
		return studentService.saveStudent(student);
	}
	
	@GetMapping("/get")
	public Flux<Student> getAllStudent() {
				
		return studentService.getAllStudent();
	}
	
	@PutMapping("/update/{id}")
	public Mono<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student)
	{
		return studentService.updateStudent(id,student);
	}
	
	@DeleteMapping("/delete/{id}")
	public Mono<Void> deleteStudent(@PathVariable("id") int id) {
		return studentService.deleteStudent(id);
	}
	
	
	
}
