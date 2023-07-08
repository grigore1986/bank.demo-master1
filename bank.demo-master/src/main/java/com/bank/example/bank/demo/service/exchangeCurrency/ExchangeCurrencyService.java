package com.bank.example.bank.demo.service.exchangeCurrency;

import com.bank.example.bank.demo.model.currency.ExchangeCurrency;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ExchangeCurrencyService {
    void addExchangeCurrency(ExchangeCurrency exchangeCurrency);

    List<ExchangeCurrency> loadAllExchangeCurrency();

    Optional<ExchangeCurrency> findExchangeCurrencyByID(long id);
    ExchangeCurrency findExchangeCurrencyByDate(Date date);

    void deleteExchangeCurrencyByID(long id);

    void updateExchangeCurrency(ExchangeCurrency exchangeCurrency);
}
