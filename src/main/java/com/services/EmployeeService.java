package com.services;


import com.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    List<Employee > getEmployee();

    Employee  deleteEmployee(Employee employee);

    Employee  create(Employee employee);

    Employee  getEmployee(int id);

    Employee  getEmployeeById(int id);

    Employee  updateEmployee(Employee employee);
    Employee  deleteEmployee (int id);



}
