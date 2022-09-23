package com.amar.springboot.cruddemo.rest;

import com.amar.springboot.cruddemo.dao.EmployeeDAO;
import com.amar.springboot.cruddemo.entity.Employee;
import com.amar.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //expose '/employee' and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //add mapping for '/employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null){
            throw new RuntimeException("Employee not found with Employee ID: "+employeeId);
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //also just in case they pass an id in Json and set it to 0
        //this is to force a save of new item..instead of update

        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmpoyee(@RequestBody Employee theEmployee){
        if(theEmployee != null){
            employeeService.save(theEmployee);
        }
        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        //throw exception is null
        if(theEmployee == null){
            throw new RuntimeException("Employee does not exist/ not found:" +employeeId);
        }
        employeeService.deleteById(employeeId);
        return "The EmployeeID: "+employeeId+" is deleted successfully";
    }


}
