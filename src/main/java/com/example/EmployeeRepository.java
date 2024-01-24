package com.example;

import java.util.List;

public interface EmployeeRepository {
	void add(Employee e);
	Employee find(Employee e);
	List<Employee> findAll();

	void save(Employee e);

	void remove(Employee e);
}
