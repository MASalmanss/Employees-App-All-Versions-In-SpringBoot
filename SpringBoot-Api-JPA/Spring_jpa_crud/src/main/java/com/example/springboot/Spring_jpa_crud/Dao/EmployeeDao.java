package com.example.springboot.Spring_jpa_crud.Dao;

import com.example.springboot.Spring_jpa_crud.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee find_by_id(int id);

    Employee save_employe(Employee employee);

    void deleteById(int id);
}
