package com.spring.springreactiveexample.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("student")
public class Student {

	@Id
	private int id;
	private String firstName;
	private String lastName;
}
