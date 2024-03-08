package com.example.springboot.Spring_jpa_crud.service;

import com.example.springboot.Spring_jpa_crud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findall();

    Employee find_by_id(int id);

    Employee save_employe(Employee employee);

    void deleteById(int id);
}
