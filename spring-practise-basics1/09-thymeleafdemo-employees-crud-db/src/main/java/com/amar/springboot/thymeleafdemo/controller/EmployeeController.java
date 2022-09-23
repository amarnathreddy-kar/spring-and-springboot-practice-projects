package com.amar.springboot.thymeleafdemo.controller;

import com.amar.springboot.thymeleafdemo.entity.Employee;
import com.amar.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    /*
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
    */
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //add mapping for '/list'
    @GetMapping("/list")
    public String listEmployees(Model theModel){
        //get employees from the db
        List<Employee> theEmployees = employeeService.findAll();

        //add it to the spring model
        theModel.addAttribute("employees", theEmployees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        //create model attribute to bind form data
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){
        //get the employee from the service
        Employee theEmployee = employeeService.findById(theId);
        //set employee as a model attribute to pre-populate the form
        theModel.addAttribute("employee", theEmployee);
        //send it over to the form
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        //save the employee
        employeeService.save(theEmployee);
        //use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){
        //delete the employee
        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }


}
