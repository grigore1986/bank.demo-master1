package com.bank.example.bank.demo.service.transferMonitoring;

import com.bank.example.bank.demo.model.bank.TransferMonitoring;
import com.bank.example.bank.demo.repository.TransferMonitoringRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TransferMonitoringServiceImpl implements TransferMonitoringService {
    @Autowired
    private TransferMonitoringRepository transferMonitoringRepository;
    @Override
    public void addTransferMonitoring(TransferMonitoring transferMonitoring) {
        transferMonitoringRepository.save(transferMonitoring);
    }

    @Override
    public TransferMonitoring findTransferMonitoringById(long id) {
      return  transferMonitoringRepository.findById(id).orElse(null);
    }
}
