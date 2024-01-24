package com.example;

import java.util.Objects;

public class Employee {

	private String id;
	private double salary;
	private boolean paid;

	public Employee(String id, double salary) {
		this.id = id;
		this.salary = salary;
	}

	public Employee() {

	}

	public String getId() {
		return id;
	}

	public Employee setId(String id) {
		this.id = id;
		return this;
	}

	public double getSalary() {
		return salary;
	}

	public Employee setSalary(double salary) {
		this.salary = salary;
		return this;
	}

	public boolean isPaid() {
		return paid;
	}

	public Employee setPaid(boolean paid) {
		this.paid = paid;
		return this;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + "]";
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		Employee employee = (Employee) object;
		return Double.compare(salary, employee.salary) == 0 && paid == employee.paid && Objects.equals(id, employee.id);
	}


}
