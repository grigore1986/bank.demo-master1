package com.bank.example.bank.demo.controller;

import com.bank.example.bank.demo.model.currency.ExchangeCurrency;
import com.bank.example.bank.demo.service.exchangeCurrency.ExchangeCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exchange/currency")
public class ExchangeCurrencyContoller {
    @Autowired
    private ExchangeCurrencyService exchangeCurrencyService;
    @PostMapping("/add")
    public void addExchangeCurrency(@RequestBody ExchangeCurrency exchangeCurrency){
        exchangeCurrencyService.addExchangeCurrency(exchangeCurrency);
    }
    @GetMapping("/all")
    public List<ExchangeCurrency> loadAllExchangeCurrency(){
        return exchangeCurrencyService.loadAllExchangeCurrency();
    }
    @GetMapping("/id/{id}")
    public Optional<ExchangeCurrency> getExchangeCurrencyByID(@PathVariable long id){
        return exchangeCurrencyService.findExchangeCurrencyByID(id);
    }
    @DeleteMapping("/id/{id}")
    public void deleteExchangeCurrencyByID(long id){
        exchangeCurrencyService.deleteExchangeCurrencyByID(id);
    }
    @PutMapping("/update")
    public void updateExchangeCurrency(ExchangeCurrency exchangeCurrency){
        exchangeCurrencyService.updateExchangeCurrency(exchangeCurrency);
    }
}
