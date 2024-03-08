package com.example.springboot.Spring_jpa_crud.service;
import com.example.springboot.Spring_jpa_crud.Dao.EmployeeDao;
import com.example.springboot.Spring_jpa_crud.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImp implements EmployeeService{


    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImp(EmployeeDao theemployeeDao){
        employeeDao =theemployeeDao;
    }

    public EmployeeServiceImp(){

    }


    @Override
    public List<Employee> findall() {
        return employeeDao.findAll();
    }

    @Override
    public Employee find_by_id(int id) {
        return employeeDao.find_by_id(id);
    }

    @Transactional
    @Override
    public Employee save_employe(Employee employee) {
        return employeeDao.save_employe(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        employeeDao.deleteById(id);

    }
}
