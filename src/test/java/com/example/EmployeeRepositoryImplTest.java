package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeRepositoryImplTest {
    EmployeeRepository repository;

    @BeforeEach
    void init() {
        repository = new EmployeeRepositoryImpl();

        repository.add(new Employee("1", 2323));
        repository.add(new Employee("2", 29));
        repository.add(new Employee("3", 19999));
    }

    @Test
    @DisplayName("Add single employee")
    void addSingleEmployee() {
        Employee employee = new Employee("4", 123);
        repository.add(employee);

        var result = repository.find(employee);
        assertThat(result)
                .as("user must be added to list with same parameters as: " + employee)
                .isEqualTo(employee);
    }

    @Test
    @DisplayName("Remove single employee")
    void removeSingleEmployee() {
        Employee employee = new Employee("1", 123);
        repository.remove(employee);
        var result = repository.find(employee);
        assertThat(result).as("User must be null after deletion").isNull();
    }

    @Test
    @DisplayName("Find existing single employee")
    void findExistingSingleEmployee() {
        Employee employee = new Employee("1", 2323);
        var result = repository.find(employee);

        assertThat(result).as("Only Existing Employees: " + result).isEqualTo(employee);
    }


    @Test
    @DisplayName("Find non existing single employee")
    void findNonExistingSingleEmployee() {
        Employee employee = new Employee("9", 123);
        var result = repository.find(employee);

        assertThat(result).as(employee + "- Must not existing").isNull();
    }

    @Test
    @DisplayName("Find All existing employees")
    void findAllExistingEmployees() {
        List<Employee> employeeList = new ArrayList<>() {{
            add(new Employee("1", 2323));
            add(new Employee("2", 29));
            add(new Employee("3", 19999));
        }};

        var result = repository.findAll();

        assertThat(result).as("List must contain 3 elements").containsExactlyElementsOf(employeeList);
    }

    @Test
    @DisplayName("Update single employee")
    void updateSingleEmployee() {
        Employee employee = new Employee("1", 12314);
        repository.save(employee);
        var result = repository.find(employee);

        assertThat(result).as("Salary must be same").isEqualTo(employee);
    }
}