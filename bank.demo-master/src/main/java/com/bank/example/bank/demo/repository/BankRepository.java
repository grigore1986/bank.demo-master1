package com.bank.example.bank.demo.repository;

import com.bank.example.bank.demo.model.bank.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

    Bank findBankByName(String bankName) throws SQLException;
    Bank findBankByAddress(String bankAddress) throws SQLException;
}
