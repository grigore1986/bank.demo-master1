package com.bank.example.bank.demo.model.client;

import com.bank.example.bank.demo.model.bank.BankBranche;
import com.bank.example.bank.demo.model.currency.Currency;
import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
  //  @Column(name = "client_id")
    private long idClient;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "idnp",unique = true)
    private String idnp;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "type_client")
    private TypeClient typeClient;

    @Column(name = "type_currensy")
    private Currency typeCurrensy;
    @Column(name = "amount_currency")
    private long amountCurrency;
    @ManyToOne
    @JoinColumn(name = "bank_branche_id")
    private BankBranche bankBranche;

    public Client() {
    }

    public Client(long idClient, String firstName, String lastName, String idnp, String phoneNumber,
                  TypeClient typeClient, Currency typeCurrensy, long amountCurrency, BankBranche bankBranche) {
        this.idClient = idClient;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idnp = idnp;
        this.phoneNumber = phoneNumber;
        this.typeClient = typeClient;
        this.typeCurrensy = typeCurrensy;
        this.amountCurrency = amountCurrency;
        this.bankBranche = bankBranche;
    }

    public Client(String firstName, String lastName, String idnp, String phoneNumber,
                  TypeClient typeClient, Currency typeCurrensy, long amountCurrency, BankBranche bankBranche) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idnp = idnp;
        this.phoneNumber = phoneNumber;
        this.typeClient = typeClient;
        this.typeCurrensy = typeCurrensy;
        this.amountCurrency = amountCurrency;
        this.bankBranche = bankBranche;
    }

    public BankBranche getBankBranche() {
        return bankBranche;
    }

    public void setBankBranche(BankBranche bankBranche) {
        this.bankBranche = bankBranche;
    }

    public Currency getTypeCurrensy() {
        return typeCurrensy;
    }

    public void setTypeCurrensy(Currency typeCurrensy) {
        this.typeCurrensy = typeCurrensy;
    }

    public long getAmountCurrency() {
        return amountCurrency;
    }

    public void setAmountCurrency(long amountCurrency) {
        this.amountCurrency = amountCurrency;
    }

    public TypeClient getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(TypeClient typeClient) {
        this.typeClient = typeClient;
    }

    public String getIdnp() {
        return idnp;
    }

    public void setIdnp(String idnp) {
        this.idnp = idnp;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idnp='" + idnp + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", typeClient=" + typeClient +
                ", typeCurrensy=" + typeCurrensy +
                ", amountCurrency=" + amountCurrency +
                '}';
    }
}
