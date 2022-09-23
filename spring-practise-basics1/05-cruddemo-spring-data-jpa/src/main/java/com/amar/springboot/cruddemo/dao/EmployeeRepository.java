package com.amar.springboot.cruddemo.dao;

import com.amar.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //that's it...implementation class are provided by spring-data-jpa
}
