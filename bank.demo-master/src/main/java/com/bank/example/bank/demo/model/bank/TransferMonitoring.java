package com.bank.example.bank.demo.model.bank;

import com.bank.example.bank.demo.model.currency.Currency;
import jakarta.persistence.*;

@Entity
@Table(name = "transfer")
public class TransferMonitoring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTransfer;
    @Column(name = "client_send")
    private long idClientSend;
    @Column(name = "Client_recevie")
    private long idClientRecevie;
    @Column(name = "amount_send")
    private long amountSend;
    @Column(name = "type_currency")
    private Currency typeCurrency;
    @Column(name = "money_status")
    private MoneyStatus moneyStatus;

    public TransferMonitoring() {
    }

    public TransferMonitoring(long idTransfer, long idClientSend, long idClientRecevie,
                              long amountSend, Currency typeCurrency, MoneyStatus moneyStatus) {
        this.idTransfer = idTransfer;
        this.idClientSend = idClientSend;
        this.idClientRecevie = idClientRecevie;
        this.amountSend = amountSend;
        this.typeCurrency = typeCurrency;
        this.moneyStatus = moneyStatus;
    }

    public TransferMonitoring(long idClientSend, long idClientRecevie,
                              long amountSend, Currency typeCurrency, MoneyStatus moneyStatus) {
        this.idClientSend = idClientSend;
        this.idClientRecevie = idClientRecevie;
        this.amountSend = amountSend;
        this.typeCurrency = typeCurrency;
        this.moneyStatus = moneyStatus;
    }

    public long getAmountSend() {
        return amountSend;
    }

    public void setAmountSend(long amountSend) {
        this.amountSend = amountSend;
    }

    public long getIdTransfer() {
        return idTransfer;
    }

    public void setIdTransfer(long idTransfer) {
        this.idTransfer = idTransfer;
    }

    public long getIdClientSend() {
        return idClientSend;
    }

    public void setIdClientSend(long idClientSend) {
        this.idClientSend = idClientSend;
    }

    public long getIdClientRecevie() {
        return idClientRecevie;
    }

    public void setIdClientRecevie(long idClientRecevie) {
        this.idClientRecevie = idClientRecevie;
    }

    public Currency getTypeCurrency() {
        return typeCurrency;
    }

    public void setTypeCurrency(Currency typeCurrency) {
        this.typeCurrency = typeCurrency;
    }

    public MoneyStatus getMoneyStatus() {
        return moneyStatus;
    }

    public void setMoneyStatus(MoneyStatus moneyStatus) {
        this.moneyStatus = moneyStatus;
    }

    @Override
    public String toString() {
        return "TransferMonitoring{" +
                "idTransfer=" + idTransfer +
                ", idClientSend=" + idClientSend +
                ", idClientRecevie=" + idClientRecevie +
                ", amountSend=" + amountSend +
                ", typeCurrency=" + typeCurrency +
                ", moneyStatus=" + moneyStatus +
                '}';
    }
}
