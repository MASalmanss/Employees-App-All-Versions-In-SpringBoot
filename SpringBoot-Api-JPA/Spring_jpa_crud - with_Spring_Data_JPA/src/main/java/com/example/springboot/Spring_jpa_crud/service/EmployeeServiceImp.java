package com.example.springboot.Spring_jpa_crud.service;
import com.example.springboot.Spring_jpa_crud.Dao.EmplooyeInterface;
import com.example.springboot.Spring_jpa_crud.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImp implements EmployeeService{


    private EmplooyeInterface employeeDao;

    @Autowired
    public EmployeeServiceImp(EmplooyeInterface theemployeeDao){
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
        Optional<Employee> result = employeeDao.findById(id);


        Employee theemploye = null;
        if(result.isPresent()){
            theemploye = result.get();
        }

        return theemploye;
    }


    @Override
    public Employee save_employe(Employee employee) {
        return employeeDao.save(employee);
    }


    @Override
    public void deleteById(int id) {
        employeeDao.deleteById(id);

    }
}
