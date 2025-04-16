package com.ashfaq.sample.models;

import java.io.Serializable;
import org.apache.beam.sdk.coders.DefaultCoder;
import org.apache.beam.sdk.coders.AvroCoder;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String department;
	private double salary;

	// Default constructor needed for Jackson
	public Employee() {
	}

	public Employee(String name, int age, String department, double salary) {
		this.name = name;
		this.age = age;
		this.department = department;
		this.salary = salary;
	}

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee{" + "name='" + name + '\'' + ", age=" + age + ", department='" + department + '\''
				+ ", salary=" + salary + '}';
	}
}