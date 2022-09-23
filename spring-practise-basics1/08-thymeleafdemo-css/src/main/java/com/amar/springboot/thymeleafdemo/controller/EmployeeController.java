package com.amar.springboot.thymeleafdemo.controller;

import com.amar.springboot.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    //load employee data

    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData(){

        //create employees
        Employee employee1 = new Employee(1,"Leslie", "Andrews", "lesliea@amar.com");
        Employee employee2 = new Employee(2,"Emma", "Andrews", "emma@amar.com");
        Employee employee3 = new Employee(3,"Lesma", "Andrews", "lesma@amar.com");
        Employee employee4 = new Employee(4,"Eellie", "Andrews", "eellie@amar.com");
        Employee employee5 = new Employee(5,"Elmaie", "Andrews", "elmaie@amar.com");

        //create the list
        theEmployees = new ArrayList<>();

        //add to the list
        theEmployees.add(employee1);
        theEmployees.add(employee2);
        theEmployees.add(employee3);
        theEmployees.add(employee4);
        theEmployees.add(employee5);
    }

    //add mapping for '/list'
    @GetMapping("/list")
    public String listEmployees(Model theModel){
        theModel.addAttribute("employees", theEmployees);
        return "list-employees";
    }
}
