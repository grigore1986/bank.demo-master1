package com.bank.example.bank.demo.repository;

import com.bank.example.bank.demo.model.bank.BankBranche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
@Repository
public interface BankBranchRepository extends JpaRepository<BankBranche, Long> {
    BankBranche findBankBrancheByName(String bankName) throws SQLException;
    BankBranche findBankBrancheByAddress(String bankAddress) throws SQLException;
}
