package com.bank.example.bank.demo.repository;

import com.bank.example.bank.demo.model.employee.EmployeeFunction;
import com.bank.example.bank.demo.model.employee.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {

    List<Employees> findEmployeesByFirstName(String firstName) throws SQLException;
    List<Employees> findEmployeesByLastName(String lastName) throws SQLException;
    List<Employees> findEmployeesByFunction(EmployeeFunction employeeFunction) throws SQLException;
    Employees findEmployeesById(long id);

}
