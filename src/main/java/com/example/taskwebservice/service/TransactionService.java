package com.example.taskwebservice.service;

import com.example.taskwebservice.domains.Transaction;
import com.example.taskwebservice.dto.PerformTransactionArguments;
import com.example.taskwebservice.dto.PerformTransactionResult;

import javax.xml.bind.JAXBElement;

public interface TransactionService {

    PerformTransactionResult addPayment(JAXBElement<PerformTransactionArguments> request);

    Transaction save(Transaction entity);

}
