package com.controller;
import  com.model.Employee;
import com.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    private static  final Logger logger = LoggerFactory.getLogger(com.controller.EmployeeController.class);

    @GetMapping
    public List<Employee> getEmployee(){
        logger.info("Employee List");
        return  employeeService.getEmployee();
    }
    @PostMapping("/create")
    public  Employee createEmployee(@RequestBody Employee employee){
        logger.info("create Employee is invoked{}",employee);
        return  employeeService.create(employee);
    }
    @GetMapping("{Id}")
    public Employee geEmployeeById(@PathVariable("id")int Id){
        logger.info("getEmployeeById is invoked with bill Id : {}",Id);
        return employeeService.getEmployeeById(Id);

    }
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return   employeeService.updateEmployee(employee);

    }
    @DeleteMapping("/{Id}")
    public  Employee deleteEmployeeById(@PathVariable("Id") int Id){
        return employeeService.deleteEmployee(Id);
    }

}
