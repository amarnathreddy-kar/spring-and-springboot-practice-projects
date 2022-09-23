package com.amar.springboot.cruddemo.dao;

import com.amar.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //that's it...implementation class are provided by spring-data-jpa
}
