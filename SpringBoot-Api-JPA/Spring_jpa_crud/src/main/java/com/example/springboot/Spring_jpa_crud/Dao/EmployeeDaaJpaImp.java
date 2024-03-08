package com.example.springboot.Spring_jpa_crud.Dao;

import com.example.springboot.Spring_jpa_crud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDaaJpaImp implements EmployeeDao{

    private EntityManager _entityManger;

    @Autowired
    public EmployeeDaaJpaImp(EntityManager _entityManger) {
        this._entityManger = _entityManger;
    }
    public EmployeeDaaJpaImp(){

    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> theQuery = _entityManger.createQuery("from Employee" , Employee.class);

        List<Employee> employees = theQuery.getResultList();


        return employees;
    }

    @Override
    public Employee find_by_id(int id) {
        Employee temp = _entityManger.find(Employee.class , id);
        return temp;
    }

    @Override
    public Employee save_employe(Employee employee) {
        Employee dbemploye = _entityManger.merge(employee);
        return dbemploye;
    }

    @Override
    public void deleteById(int id) {

        Employee employee = _entityManger.find(Employee.class , id);

        _entityManger.remove(employee);

    }
}
