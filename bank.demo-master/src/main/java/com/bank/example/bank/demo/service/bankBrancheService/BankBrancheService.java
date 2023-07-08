package com.bank.example.bank.demo.service.bankBrancheService;

import com.bank.example.bank.demo.model.bank.BankBranche;
import com.bank.example.bank.demo.model.client.Client;

import java.sql.SQLException;
import java.util.Currency;
import java.util.List;

public interface BankBrancheService {

    void addBankBranche(BankBranche bankBranche);
    List<BankBranche> loadAllBankBranche();
    List<BankBranche> findBankBrancheByName(String name);
    List<BankBranche> findBankBrancheByAddress(String address);
    BankBranche getBankBrancheByID(long id);
    void deleteBankBrancheByID(long id);
    void updateBankBranche(BankBranche bankBranche);

    void changeMoney(Client client, Currency toCurrency, BankBranche bankBranche);
    void changeMoneyService(long idClient, Currency toCurrency, long idBankBranche, long idEmployee);
    void sendMoney(long idSendClient, long  idSendBankBranche,
                   long idEmployeeFromSendBankBranche, long idReciveClient );
    void receiveMoney(long idReceiveClient, long idReceveBankBranke,
                      long idEmployeeFromReceiveBankBranke, long idTransfer);
}
