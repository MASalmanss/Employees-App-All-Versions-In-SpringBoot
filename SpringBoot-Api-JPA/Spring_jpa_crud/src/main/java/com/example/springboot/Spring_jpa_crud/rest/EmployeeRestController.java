package com.example.springboot.Spring_jpa_crud.rest;


import com.example.springboot.Spring_jpa_crud.Dao.EmployeeDao;
import com.example.springboot.Spring_jpa_crud.entity.Employee;
import com.example.springboot.Spring_jpa_crud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findall();
    }


    @GetMapping("/employees/{employeeid}")
    public Employee find_by_id(@PathVariable Integer employeeid){

        Employee tempEmp = employeeService.find_by_id(employeeid);

        if(tempEmp == null){
            throw new RuntimeException("Employeeid not found");
        }

       return  tempEmp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmplooye){
        theEmplooye.setId(0);

        Employee dbemplooye = employeeService.save_employe(theEmplooye);
        return dbemplooye;
    }

    @PutMapping("/employees")
    public Employee updateEmpoyee(@RequestBody Employee theEmployee){
        Employee dbemplooye = employeeService.save_employe(theEmployee);
        return dbemplooye;
    }

    @DeleteMapping("/employees/{employeeid}")
    public String deleteEmployee(@PathVariable int employeeid)
    {
        Employee tempEmp = employeeService.find_by_id(employeeid);

        if(tempEmp == null){
            throw new RuntimeException("Employee id not found -" + employeeid);
        }
        employeeService.deleteById(employeeid);


        return "Deleted emplooyeId - "  + employeeid;
    }
}
