package com.bank.example.bank.demo.service.exchangeCurrency;

import com.bank.example.bank.demo.model.currency.ExchangeCurrency;
import com.bank.example.bank.demo.repository.ExchangeCurrencyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExchangeCurrencyServiceImpl implements ExchangeCurrencyService{
    @Autowired
    private ExchangeCurrencyRepository exchangeCurrencyRepository;
    @Override
    public void addExchangeCurrency(ExchangeCurrency exchangeCurrency) {
        System.out.println("service for add ExchangeCurrency");
        exchangeCurrencyRepository.save(exchangeCurrency);

    }

    @Override
    public List<ExchangeCurrency> loadAllExchangeCurrency() {
        System.out.println("service load all ExchangeCurrency ");
        return exchangeCurrencyRepository.findAll();
    }

    @Override
    public Optional<ExchangeCurrency> findExchangeCurrencyByID(long id) {
        System.out.println("service find ExchangeCurrency by id");

        Optional<ExchangeCurrency> exchangeCurrency = exchangeCurrencyRepository.findById(id);
        return exchangeCurrency;
    }

    @Override
    public ExchangeCurrency findExchangeCurrencyByDate(Date date) {
        System.out.println("service find ExchangeCurrency by date");
        ExchangeCurrency exchangeCurrency = null;
        try {
            exchangeCurrency = exchangeCurrencyRepository.findExchangeCurrencyByDate(date);
        } catch (SQLException e){
            e.printStackTrace();
            //TODO: afisare care utlilzator
        }
        return exchangeCurrency;
    }

    @Override
    public void deleteExchangeCurrencyByID(long id) {
        System.out.println("service for delete by id");
        exchangeCurrencyRepository.deleteById(id);

    }

    @Override
    public void updateExchangeCurrency(ExchangeCurrency exchangeCurrency) {
        System.out.println("service update exchange currency");

//        ExchangeCurrency existingExchangeCurrency = null;
//        existingExchangeCurrency = exchangeCurrencyRepository.findById(exchangeCurrency.getIdExchangeCurrency());
//
//        existingExchangeCurrency.se
//        TODO:service for update

    }
}
