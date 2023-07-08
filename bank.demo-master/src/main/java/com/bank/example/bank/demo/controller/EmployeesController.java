package com.bank.example.bank.demo.controller;

import com.bank.example.bank.demo.model.employee.Employees;
import com.bank.example.bank.demo.service.employeesService.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;

    @PostMapping("/add")
    public void addEmployees(@RequestBody Employees employees) {
        employeesService.addEmployees(employees);
    }

    @GetMapping("/all")
    public List<Employees> getAllClient() {
        return employeesService.loadAllEmployees();
    }

    //TODO : all controler
}
