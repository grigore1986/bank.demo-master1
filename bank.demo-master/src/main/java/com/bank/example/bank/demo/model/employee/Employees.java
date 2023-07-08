package com.bank.example.bank.demo.model.employee;

import com.bank.example.bank.demo.model.bank.BankBranche;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employees {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "employee_function")
    private EmployeeFunction function;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "bank_branche_id")
    private BankBranche bankBranche;

    public Employees() {
    }

    public Employees(String firstName, String lastName, String mobileNumber, EmployeeFunction function,
                     BankBranche bankBranche) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.function = function;
        this.bankBranche = bankBranche;
    }

    public Employees(long id, String firstName, String lastName, String mobileNumber, EmployeeFunction function,
                     BankBranche bankBranche) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.function = function;
        this.bankBranche = bankBranche;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public EmployeeFunction getFunction() {
        return function;
    }

    public void setFunction(EmployeeFunction function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", function=" + function +
                ", bankBranche=" + bankBranche +
                '}';
    }
}
