package com.bank.example.bank.demo.service.transferMonitoring;

import com.bank.example.bank.demo.model.bank.TransferMonitoring;

public interface TransferMonitoringService {

    void  addTransferMonitoring(TransferMonitoring transferMonitoring);
    TransferMonitoring findTransferMonitoringById(long id);
}
