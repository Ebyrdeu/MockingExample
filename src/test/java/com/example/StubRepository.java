package com.example;

import java.util.ArrayList;
import java.util.List;

public class StubRepository implements EmployeeRepository {
    private final List<Employee> list = new ArrayList<>();
    private int countAddedUsers;
    private int countFoundAllUsers;

    public int getCountAddedUsers() {
        return countAddedUsers;
    }

    public int getCountFoundAllUsers() {
        return countFoundAllUsers;
    }

    @Override
    public void add(Employee e) {
        list.add(e);
        countAddedUsers++;
    }

    @Override
    public Employee find(Employee e) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        countFoundAllUsers++;
        return  new ArrayList<>(list);
    }

    @Override
    public void save(Employee e) {

    }

    @Override
    public void remove(Employee e) {

    }
}
