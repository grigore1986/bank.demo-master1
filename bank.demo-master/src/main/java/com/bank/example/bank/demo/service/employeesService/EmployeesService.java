package com.bank.example.bank.demo.service.employeesService;

import com.bank.example.bank.demo.model.employee.EmployeeFunction;
import com.bank.example.bank.demo.model.employee.Employees;

import java.util.List;

public interface EmployeesService {

    void addEmployees(Employees employees);

    List<Employees> loadAllEmployees();

    List<Employees> loadAllEmployeesByBrancheID(long idBrache);

    List<Employees> findEmployeesByFirstName(String firstName);

    List<Employees> findEmployeesByLastName(String lastName);

    List<Employees> findEmployeesByFunction(EmployeeFunction employeeFunction);

    Employees findEmployeesByID(long id);

    void deleteEmployeesByID(long id);

    void updateEmployees(Employees employees);
}
