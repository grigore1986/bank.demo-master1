package com.bank.example.bank.demo.controller;

import com.bank.example.bank.demo.model.bank.Bank;
import com.bank.example.bank.demo.model.bank.BankBranche;
import com.bank.example.bank.demo.model.client.Client;
import com.bank.example.bank.demo.service.bankBrancheService.BankBrancheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Currency;
import java.util.List;

@RestController
@RequestMapping("/bankbranche")
public class BankBranchController {
    @Autowired
    private BankBrancheService bankBrancheService;

    @PostMapping("/add")
    public void addBankBranche(@RequestBody BankBranche bankBranche) {
        bankBrancheService.addBankBranche(bankBranche);
    }

    @GetMapping("/all")
    public List<BankBranche> getAllBank() {
        return bankBrancheService.loadAllBankBranche();
    }

    @GetMapping("/branchename/{brancheName}")
    public List<BankBranche> findBankBrancheByName(@PathVariable String brancheName) {
        return bankBrancheService.findBankBrancheByName(brancheName);
    }

    @GetMapping("/address/{brancheAddress}")
    public List<BankBranche> findBankBrancheByAddress(@PathVariable String brancheAddress) {
        return bankBrancheService.findBankBrancheByAddress(brancheAddress);
    }

    @GetMapping("/id/{id}")
    public  BankBranche getBankBrancheByID(@PathVariable long id) {
        return bankBrancheService.getBankBrancheByID(id);
    }

    @DeleteMapping("/id/{id}")
    public  void deleteBankBrancheByID(@PathVariable long id) {
        bankBrancheService.deleteBankBrancheByID(id);
    }

    @PutMapping("/update")
    public  void updateBankBrache(@RequestBody BankBranche bankBranche) {
        bankBrancheService.updateBankBranche(bankBranche);
    }
    @PostMapping("/change/money/{toCurrency}")
    public void changeMoney(@RequestBody Client client,@PathVariable Currency toCurrency,
                            @RequestBody BankBranche bankBranche){
        bankBrancheService.changeMoney(client,toCurrency,bankBranche);
    }

    @GetMapping("/change/money/{idClient}/{toCurrency}/{idBankBranche}/{idEmployee}")
    public void changeMoneyService(@PathVariable long idClient, @PathVariable  Currency toCurrency,
                                   @PathVariable long idBankBranche, @PathVariable  long idEmployee){
        bankBrancheService.changeMoneyService(idClient,toCurrency, idBankBranche, idEmployee);
    }

    @GetMapping("/send/money/sc_{idSendClient}/sb_{idSendBankBranche}/se_{idEmployeeFromSendBankBranche}/rc_{idReciveClient}")
    public void sendMoneyService(@PathVariable long idSendClient, @PathVariable  long idSendBankBranche,
                                 @PathVariable long idEmployeeFromSendBankBranche, @PathVariable  long idReciveClient){
        bankBrancheService.sendMoney(idSendClient, idSendBankBranche, idEmployeeFromSendBankBranche,
                idReciveClient);
    }
    @GetMapping("/receive/money/rc_{idReceiveClient}/rb_{idReceveBankBranke}/re_{idEmployeeFromReceiveBankBranke}/tr_{idTransfer}")
    public void receiveMoneyService(@PathVariable long idReceiveClient, @PathVariable long idReceveBankBranke,
                                    @PathVariable long idEmployeeFromReceiveBankBranke, @PathVariable long idTransfer ){
        bankBrancheService.receiveMoney(idReceiveClient, idReceveBankBranke, idEmployeeFromReceiveBankBranke, idTransfer);

    }
}
