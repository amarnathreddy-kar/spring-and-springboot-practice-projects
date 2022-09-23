package com.amar.springboot.cruddemo.service;

import com.amar.springboot.cruddemo.dao.EmployeeRepository;
import com.amar.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeDAO){
        this.employeeRepository = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        //return employeeRepository.findById(theId);
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Did not find the EmployeeID: "+theId);
        }
        return theEmployee;
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
