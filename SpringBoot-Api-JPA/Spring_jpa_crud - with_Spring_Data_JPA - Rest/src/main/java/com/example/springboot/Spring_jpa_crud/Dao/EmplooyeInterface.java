package com.example.springboot.Spring_jpa_crud.Dao;

import com.example.springboot.Spring_jpa_crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface EmplooyeInterface extends JpaRepository<Employee , Integer> {
}
