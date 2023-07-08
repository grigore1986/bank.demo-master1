package com.bank.example.bank.demo.repository;

import com.bank.example.bank.demo.model.bank.TransferMonitoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferMonitoringRepository extends JpaRepository<TransferMonitoring, Long> {
}
