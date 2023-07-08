package com.bank.example.bank.demo.service.bankService;

import com.bank.example.bank.demo.model.bank.Bank;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface BankService {

    void addBank(Bank bank);

    List<Bank> loadAllBank();

    List<Bank> findBankByName(String bankName);

    List<Bank> findBankByAddress(String bankAddress);

    Bank getBankById(long id);

    void deleteBankByID(long id);

    void updateBank(Bank bank);

    void sendMoneyToBranch(long idBank);

    void receiveMoneyFromBranch(long idBank);

}
