package com.bank.example.bank.demo.controller;

import com.bank.example.bank.demo.model.bank.Bank;
import com.bank.example.bank.demo.model.client.Client;
import com.bank.example.bank.demo.service.bankService.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    private BankService bankService;

    @PostMapping("/add")
    public void addBank(@RequestBody Bank bank) {
        bankService.addBank(bank);
    }

    @GetMapping("/all")
    public List<Bank> getAllBank() {
        return bankService.loadAllBank();
    }

    @GetMapping("/name/{bankName}")
    public List<Bank> findBankByName(@PathVariable String bankName) {
        return bankService.findBankByName(bankName);
    }

    @GetMapping("/address/{bankAddress}")
    public List<Bank> findBankByAddress(@PathVariable String bankAddress) {
        return bankService.findBankByAddress(bankAddress);
    }

    @GetMapping("/id/{id}")
    Bank getBankByID(@PathVariable long id) {
        return bankService.getBankById(id);
    }

    @DeleteMapping("/id/{id}")
    void deleteBankByID(@PathVariable long id) {
        bankService.deleteBankByID(id);
    }

    @PutMapping("/update")
    void updateBank(@RequestBody Bank bank) {
        bankService.updateBank(bank);
    }
    @GetMapping("/send/branch/{idBank}")
    void sendMoneyToBranche(@PathVariable long idBank){
        bankService.sendMoneyToBranch(idBank);
    }
    @GetMapping("/receive/branch/{idBank}")
    void receiveMoneyFromBranche(@PathVariable long idBank){
        bankService.receiveMoneyFromBranch(idBank);
    }


}
