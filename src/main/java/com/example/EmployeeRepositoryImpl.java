package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final Map<String, Employee> database = new HashMap<>();

    @Override
    public void add(Employee e) {
        database.put(e.getId(), e);
    }

    @Override
    public Employee find(Employee e) {
        return database.get(e.getId());
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public void save(Employee e) {
        database.put(e.getId(), e);
    }

    @Override
    public void remove(Employee e) {
        database.remove(e.getId());
    }

}
