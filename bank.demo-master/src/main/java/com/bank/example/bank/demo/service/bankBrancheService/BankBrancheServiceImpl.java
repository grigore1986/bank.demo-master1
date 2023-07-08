package com.bank.example.bank.demo.service.bankBrancheService;

import com.bank.example.bank.demo.exeption.InvalidClientTypeException;
import com.bank.example.bank.demo.exeption.InvalidPositionException;
import com.bank.example.bank.demo.exeption.InvalidStatutMoneyException;
import com.bank.example.bank.demo.model.bank.BankBranche;
import com.bank.example.bank.demo.model.bank.MoneyStatus;
import com.bank.example.bank.demo.model.bank.TransferMonitoring;
import com.bank.example.bank.demo.model.client.Client;
import com.bank.example.bank.demo.model.client.TypeClient;
import com.bank.example.bank.demo.model.currency.*;
import com.bank.example.bank.demo.model.employee.EmployeeFunction;
import com.bank.example.bank.demo.model.employee.Employees;
import com.bank.example.bank.demo.repository.BankBranchRepository;
import com.bank.example.bank.demo.service.clientService.ClientService;
import com.bank.example.bank.demo.service.employeesService.EmployeesService;
import com.bank.example.bank.demo.service.transferMonitoring.TransferMonitoringService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Service
@Transactional
public class BankBrancheServiceImpl implements BankBrancheService {
    @Autowired
    private BankBranchRepository bankBranchRepository;


    @Override
    public void addBankBranche(BankBranche bankBranche) {
        System.out.println("service to add bankbrach");
        bankBranchRepository.save(bankBranche);
    }

    @Override
    public List<BankBranche> loadAllBankBranche() {
        System.out.println("service load all bank brach");
        return bankBranchRepository.findAll();
    }

    @Override
    public List<BankBranche> findBankBrancheByName(String name) {

        System.out.println("Service - Finding bank branches by name");
        List<BankBranche> bankBranches = new ArrayList<>();
        BankBranche bankBranche = null;
        try {
            bankBranche = bankBranchRepository.findBankBrancheByName(name);
            bankBranches.add(bankBranche);
        } catch (SQLException e) {
            e.printStackTrace();
            //TODO: trebui de afisare catre utlizator
        }
        return bankBranches;
    }

    @Override
    public List<BankBranche> findBankBrancheByAddress(String address) {
        List<BankBranche> bankBranches = new ArrayList<>();
        BankBranche bankBranche = null;
        System.out.println("Service - Finding bank branches by address");
        try {
            bankBranche = bankBranchRepository.findBankBrancheByAddress(address);
            bankBranches.add(bankBranche);
        } catch (SQLException e) {
            e.printStackTrace();
            //TODO: trebui de afisare catre utlizator
        }
        return bankBranches;
    }

    @Override
    public BankBranche getBankBrancheByID(long id) {
        System.out.println("service for find by id bankBrache");
        return bankBranchRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBankBrancheByID(long id) {
        System.out.println("Service - Deleting bank branch by ID");
        bankBranchRepository.deleteById(id);
    }

    @Override
    public void updateBankBranche(BankBranche bankBranche) {
        System.out.println("Service - Update bank branch");
        BankBranche existingBankBranche = bankBranchRepository.findById(bankBranche.getId()).orElse(null);
        if (existingBankBranche == null) {
            throw new RuntimeException("Bank branch not found");
        }
        existingBankBranche.setName(bankBranche.getName());
        existingBankBranche.setAddress(bankBranche.getAddress());
        existingBankBranche.setBrancheBalanceMDL(bankBranche.getBrancheBalanceMDL());
        existingBankBranche.setBrancheBalanceEUR(bankBranche.getBrancheBalanceEUR());
        existingBankBranche.setBrancheBalanceUSD(bankBranche.getBrancheBalanceUSD());
        existingBankBranche.setBrancheBalanceRON(bankBranche.getBrancheBalanceRON());

        bankBranchRepository.save(existingBankBranche);
    }

    @Override
    public void changeMoney(Client client, Currency toCurrency, BankBranche bankBranche) {

//        List<Employees> employeesList = bankBranche.getEmployees();
//
//        ExchangeCurrency exchangeCurrency = bankBranche.getExchangeCurrency();
//
//        for (Employees employees : employeesList) {
//            System.out.println(employees + " my employee is");
//            if (employees.getFunction().equals(EmployeeFunction.CASIER)) {
//                System.out.println("se deservest de ");
//                if (client.getTypeClient().equals(TypeClient.CHANGE)) {
//                    // MDL --> all
//                    if (client.getTypeCurrensy().equals(com.bank.example.bank.demo.model.currency.Currency.MDL)
//                            && toCurrency.equals(com.bank.example.bank.demo.model.currency.Currency.EUR)) {
//
//                        bankBranche.setBrancheBalanceMDL(bankBranche.getBrancheBalanceMDL() + client.getAmountCurrency());
//                        double changedMoney = client.getAmountCurrency() * exchangeCurrency.getBuyEUR();
//                        client.setTypeCurrensy(com.bank.example.bank.demo.model.currency.Currency.EUR);
//                        bankBranche.setBrancheBalanceEUR((long) (bankBranche.getBrancheBalanceEUR() - (changedMoney - 0.99)));
//                        client.setAmountCurrency((long) (changedMoney - (changedMoney * 0.01))); // comisionul
//
//
//                        System.out.println("================================================\n" + changedMoney);
//                        //TODO:
//                    }
//
//                }
//            }
//        }

        //TODO: changeMoney
    }

    @Autowired
    private ClientService clientService;
    @Autowired
    private EmployeesService employeesService;

    @Override
    public void changeMoneyService(long idClient, Currency toCurrency, long idBankBranche, long idEmployee) {

        Client client = clientService.findClientByID(idClient);
        BankBranche bankBranche = getBankBrancheByID(idBankBranche);
        Employees employees = employeesService.findEmployeesByID(idEmployee);
        com.bank.example.bank.demo.model.currency.Currency currencyEUR = com.bank.example.bank.demo.model.currency.Currency.EUR;
        ExchangeCurrency exchangeCurrency = bankBranche.getExchangeCurrency();

        if (employees.getFunction().equals(EmployeeFunction.CASIER)) {
            System.out.println("se deservest de " + employees.getFirstName());
            if (client.getTypeClient().equals(TypeClient.CHANGE)) {
                // MDL --> all

                if (client.getTypeCurrensy().equals(com.bank.example.bank.demo.model.currency.Currency.MDL)) {

                    if (toCurrency.toString().equals(com.bank.example.bank.demo.model.currency.Currency.EUR.toString())) {

                        System.out.println("clientul schimba MDL to EUR");
                        bankBranche.setBrancheBalanceMDL(bankBranche.getBrancheBalanceMDL() + client.getAmountCurrency()); //luam bani MDL
                        double changedMoney = client.getAmountCurrency() / exchangeCurrency.getBuyEUR(); // impartim la curs EUR
                        client.setTypeCurrensy(com.bank.example.bank.demo.model.currency.Currency.EUR); // stiulam ca intoarecm euro
                        double recevedchangedMoney = changedMoney - (changedMoney * 0.2);
                        bankBranche.setBrancheBalanceEUR((long) (bankBranche.getBrancheBalanceEUR() - recevedchangedMoney)); // stocatem din banca bani
                        client.setAmountCurrency((long) recevedchangedMoney); // comisionul
                    }

                    if (toCurrency.toString().equals(com.bank.example.bank.demo.model.currency.Currency.USD.toString())) {

                        System.out.println("sclientul schimba MDL to USD");
                        bankBranche.setBrancheBalanceUSD(bankBranche.getBrancheBalanceMDL() + client.getAmountCurrency()); //luam bani MDL
                        double changedMoney = client.getAmountCurrency() / exchangeCurrency.getBuyUSD(); // impartim la curs usd
                        client.setTypeCurrensy(com.bank.example.bank.demo.model.currency.Currency.USD); // stiulam ca intoarecm euro
                        double recevedchangedMoney = changedMoney - (changedMoney * 0.2);
                        bankBranche.setBrancheBalanceUSD((long) (bankBranche.getBrancheBalanceUSD() - recevedchangedMoney)); // stocatem din banca bani
                        client.setAmountCurrency((long) recevedchangedMoney); // comisionul
                    }

                    if (toCurrency.toString().equals(com.bank.example.bank.demo.model.currency.Currency.RON.toString())) {

                        System.out.println("sclientul schimba MDL to RON");
                        bankBranche.setBrancheBalanceRON(bankBranche.getBrancheBalanceMDL() + client.getAmountCurrency()); //luam bani MDL
                        double changedMoney = client.getAmountCurrency() / exchangeCurrency.getBuyRON(); // impartim la curs usd
                        client.setTypeCurrensy(com.bank.example.bank.demo.model.currency.Currency.RON); // stiulam ca intoarecm euro
                        double recevedchangedMoney = changedMoney - (changedMoney * 0.2);
                        bankBranche.setBrancheBalanceRON((long) (bankBranche.getBrancheBalanceUSD() - recevedchangedMoney)); // stocatem din banca bani
                        client.setAmountCurrency((long) recevedchangedMoney); // comisionul
                    }

                } else {
                    throw new InvalidClientTypeException("to chnage money, the client's type must be chnage");
                }
            } else {
                throw new InvalidPositionException("Wrong function of the bank employee!!!");
            }
        }
    }

    @Autowired
    private TransferMonitoringService transferMonitoringService;

    @Override
    public void sendMoney(long idSendClient, long idSendBankBranche,
                          long idEmployeeFromSendBankBranche, long idReciveClient) {
        Client clientToSend = clientService.findClientByID(idSendClient);
        BankBranche bankBrancheSend = getBankBrancheByID(idSendBankBranche);

        Employees EmployeeFromSendBankBranche = employeesService.findEmployeesByID(idEmployeeFromSendBankBranche);

        if (EmployeeFromSendBankBranche.getFunction().equals(EmployeeFunction.CASIER)) {

            if (clientToSend.getTypeClient().equals(TypeClient.SEND)) {

                // procuentul bancii procentru transfer
                if (clientToSend.getTypeCurrensy().equals(com.bank.example.bank.demo.model.currency.Currency.MDL)) {
                    bankBrancheSend.setBrancheBalanceMDL((long)
                            (bankBrancheSend.getBrancheBalanceMDL() + clientToSend.getAmountCurrency() * 0.1));
                } else if (clientToSend.getTypeCurrensy().equals(com.bank.example.bank.demo.model.currency.Currency.USD)) {
                    bankBrancheSend.setBrancheBalanceUSD((long)
                            (bankBrancheSend.getBrancheBalanceUSD() + clientToSend.getAmountCurrency() * 0.1));
                } else if (clientToSend.getTypeCurrensy().equals(com.bank.example.bank.demo.model.currency.Currency.EUR)) {
                    bankBrancheSend.setBrancheBalanceEUR((long)
                            (bankBrancheSend.getBrancheBalanceEUR() + clientToSend.getAmountCurrency() * 0.1));
                } else if (clientToSend.getTypeCurrensy().equals(com.bank.example.bank.demo.model.currency.Currency.RON)) {
                    bankBrancheSend.setBrancheBalanceRON((long)
                            (bankBrancheSend.getBrancheBalanceRON() + clientToSend.getAmountCurrency() * 0.1));
                } else {
                    throw new RuntimeException("dont find money type");
                }

                double sendMoney = clientToSend.getAmountCurrency() * 0.9;
                clientToSend.setAmountCurrency(0);
                // intrgistram in baza de date transferul
                TransferMonitoring transferMonitoring = new TransferMonitoring(idSendClient, idReciveClient,
                        (long) sendMoney, clientToSend.getTypeCurrensy(), MoneyStatus.WAITING);
                transferMonitoringService.addTransferMonitoring(transferMonitoring);
            } else {
                throw new InvalidClientTypeException("to send money, the client's type must be SEND");
            }
        } else {
            throw new InvalidPositionException("Wrong function of the bank employee!!!");

        }
    }

    @Override
    public void receiveMoney(long idReceiveClient, long idReceveBankBranke,
                             long idEmployeeFromReceiveBankBranke, long idTransfer) {

        Client clientReceive = clientService.findClientByID(idReceiveClient);
        BankBranche bankBrancheReceive = getBankBrancheByID(idReceveBankBranke);
        Employees employeesReceiveBranch = employeesService.findEmployeesByID(idEmployeeFromReceiveBankBranke);
        TransferMonitoring transferReceveFromBranch = transferMonitoringService.findTransferMonitoringById(idTransfer);
        System.out.println("client recev is  " + clientReceive);

        if (employeesReceiveBranch.getFunction().equals(EmployeeFunction.CASIER)) {
            if (clientReceive.getTypeClient().equals(TypeClient.RECEIV)) {
                if (transferReceveFromBranch.getMoneyStatus().equals(MoneyStatus.WAITING)) { // verficam statul transferului
                    clientReceive.setAmountCurrency((long) (transferReceveFromBranch.getAmountSend() * 0.9));
                    clientReceive.setTypeCurrensy(transferReceveFromBranch.getTypeCurrency());

                    // procuentul bancii procentru transfer
                    if (clientReceive.getTypeCurrensy().equals(com.bank.example.bank.demo.model.currency.Currency.MDL)) {
                        bankBrancheReceive.setBrancheBalanceMDL((long)
                                (bankBrancheReceive.getBrancheBalanceMDL() + clientReceive.getAmountCurrency() * 0.1));
                    } else if (clientReceive.getTypeCurrensy().equals(com.bank.example.bank.demo.model.currency.Currency.USD)) {
                        bankBrancheReceive.setBrancheBalanceUSD((long)
                                (bankBrancheReceive.getBrancheBalanceUSD() + clientReceive.getAmountCurrency() * 0.1));
                    } else if (clientReceive.getTypeCurrensy().equals(com.bank.example.bank.demo.model.currency.Currency.EUR)) {
                        bankBrancheReceive.setBrancheBalanceEUR((long)
                                (bankBrancheReceive.getBrancheBalanceEUR() + clientReceive.getAmountCurrency() * 0.1));
                    } else if (clientReceive.getTypeCurrensy().equals(com.bank.example.bank.demo.model.currency.Currency.RON)) {
                        bankBrancheReceive.setBrancheBalanceRON((long)
                                (bankBrancheReceive.getBrancheBalanceRON() + clientReceive.getAmountCurrency() * 0.1));
                    } else {
                        throw new RuntimeException("dont find money type");
                    }
                    transferReceveFromBranch.setMoneyStatus(MoneyStatus.RECEIVED);

                } else {
                    throw new InvalidStatutMoneyException("Wrong money status of the transfer, must be WAITING!!!");
                }
            } else {
                throw new InvalidClientTypeException("to receiv money, the client's type must be receiv");
            }
        } else {
            throw new InvalidPositionException("Wrong function of the bank employee!!!");
        }

        System.out.println("\nclient recev is  " + clientReceive);
        System.out.println("\n transfer" + transferReceveFromBranch);
    }

}
