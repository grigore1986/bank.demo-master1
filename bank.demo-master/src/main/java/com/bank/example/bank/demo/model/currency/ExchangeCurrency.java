package com.bank.example.bank.demo.model.currency;

import com.bank.example.bank.demo.model.bank.BankBranche;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ExchangeCurrency")
public class ExchangeCurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idExchangeCurrency;
//    @Column(name = "sellMDL")
//    private long sellMDL;
//    @Column(name = "buyMDL")
//    private long buyMDL;
    @Column(name = "sellUSD")
    private double sellUSD;
    @Column(name = "buyUSD")
    private double buyUSD;
    @Column(name = "sellEUR")
    private double sellEUR;
    @Column(name = "buyEUR")
    private double buyEUR;
    @Column(name = "sellRON")
    private double sellRON;
    @Column(name = "buyRON")
    private double buyRON;
    @JsonIgnore
    @OneToMany
    private List<BankBranche> bankBrancheList = new ArrayList<>();
    @Column(name = "date")
    private Date date;

    public ExchangeCurrency() {
    }

    public ExchangeCurrency(long idExchangeCurrency, double sellUSD, double buyUSD, double sellEUR, double buyEUR,
                            double sellRON, double buyRON, List<BankBranche> bankBrancheList, Date date) {
        this.idExchangeCurrency = idExchangeCurrency;
//        this.sellMDL = sellMDL;
//        this.buyMDL = buyMDL;
        this.sellUSD = sellUSD;
        this.buyUSD = buyUSD;
        this.sellEUR = sellEUR;
        this.buyEUR = buyEUR;
        this.sellRON = sellRON;
        this.buyRON = buyRON;
        this.bankBrancheList = bankBrancheList;
        this.date = date;
    }

    public ExchangeCurrency(float sellUSD, double buyUSD, double sellEUR, double buyEUR,
                            double sellRON, double buyRON, List<BankBranche> bankBrancheList, Date date) {
//        this.sellMDL = sellMDL;
//        this.buyMDL = buyMDL;
        this.sellUSD = sellUSD;
        this.buyUSD = buyUSD;
        this.sellEUR = sellEUR;
        this.buyEUR = buyEUR;
        this.sellRON = sellRON;
        this.buyRON = buyRON;
        this.bankBrancheList = bankBrancheList;
        this.date = date;
    }

    public long getIdExchangeCurrency() {
        return idExchangeCurrency;
    }

    public void setIdExchangeCurrency(long idExchangeCurrency) {
        this.idExchangeCurrency = idExchangeCurrency;
    }

//    public long getSellMDL() {
//        return sellMDL;
//    }
//
//    public void setSellMDL(long sellMDL) {
//        this.sellMDL = sellMDL;
//    }
//
//    public long getBuyMDL() {
//        return buyMDL;
//    }
//
//    public void setBuyMDL(long buyMDL) {
//        this.buyMDL = buyMDL;
//    }

    public double getSellUSD() {
        return sellUSD;
    }

    public void setSellUSD(long sellUSD) {
        this.sellUSD = sellUSD;
    }

    public double getBuyUSD() {
        return buyUSD;
    }

    public void setBuyUSD(long buyUSD) {
        this.buyUSD = buyUSD;
    }

    public double getSellEUR() {
        return sellEUR;
    }

    public void setSellEUR(long sellEUR) {
        this.sellEUR = sellEUR;
    }

    public double getBuyEUR() {
        return buyEUR;
    }

    public void setBuyEUR(long buyEUR) {
        this.buyEUR = buyEUR;
    }

    public double getSellRON() {
        return sellRON;
    }

    public void setSellRON(long sellRON) {
        this.sellRON = sellRON;
    }

    public double getBuyRON() {
        return buyRON;
    }

    public void setBuyRON(long buyRON) {
        this.buyRON = buyRON;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<BankBranche> getBankBrancheList() {
        return bankBrancheList;
    }

    public void setBankBrancheList(List<BankBranche> bankBrancheList) {
        this.bankBrancheList = bankBrancheList;
    }

    @Override
    public String toString() {
        return "ExchangeCurrency{" +
                "idExchangeCurrency=" + idExchangeCurrency +
//                ", sellMDL=" + sellMDL +
//                ", buyMDL=" + buyMDL +
                ", sellUSD=" + sellUSD +
                ", buyUSD=" + buyUSD +
                ", sellEUR=" + sellEUR +
                ", buyEUR=" + buyEUR +
                ", sellRON=" + sellRON +
                ", buyRON=" + buyRON +
                ", bankBranche=" + bankBrancheList +
                ", date=" + date +
                '}';
    }
}
