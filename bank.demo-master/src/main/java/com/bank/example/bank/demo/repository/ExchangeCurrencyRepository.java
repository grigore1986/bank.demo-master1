package com.bank.example.bank.demo.repository;

import com.bank.example.bank.demo.model.currency.ExchangeCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Date;

@Repository
public interface ExchangeCurrencyRepository extends JpaRepository<ExchangeCurrency, Long> {
    ExchangeCurrency findExchangeCurrencyByDate(Date date) throws SQLException;
}
