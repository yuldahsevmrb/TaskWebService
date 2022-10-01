package com.example.taskwebservice.service;

import com.example.taskwebservice.domains.Client;
import com.example.taskwebservice.domains.Transaction;
import com.example.taskwebservice.dto.GenericParam;
import com.example.taskwebservice.dto.PerformTransactionArguments;
import com.example.taskwebservice.dto.PerformTransactionResult;
import com.example.taskwebservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBElement;
import java.math.BigDecimal;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    AccountService accountService;

    @Autowired
    ClientService clientService;

    @Autowired
    TransactionRepository transactionRepository;

    
    @Override
    public PerformTransactionResult addPayment(JAXBElement<PerformTransactionArguments> request) {
        String client_id = Utils.getValueByKey(request.getValue().getParameters(), "customer_id");

        Client client = clientService.getClient(client_id).get();
        long amount = request.getValue().getAmount()/100;
        client.setAccount(accountService.updateAccount(client, amount));

        Transaction transaction = new Transaction(client.getAccount().getNumber(), BigDecimal.valueOf(amount));
        transaction = save(transaction);

        PerformTransactionResult performTransactionResult = new PerformTransactionResult();
        GenericParam resultParam = new GenericParam();


        resultParam.setParamKey("balance");
        resultParam.setParamValue(String.valueOf(client.getAccount().getBalance()));
        performTransactionResult.getParameters().add(resultParam);

        resultParam = new GenericParam();
        resultParam.setParamKey("traffic");
        resultParam.setParamValue("25600");
        performTransactionResult.getParameters().add(resultParam);

        resultParam = new GenericParam();
        resultParam.setParamKey("date");
        resultParam.setParamValue(String.valueOf(transaction.getDate_created()));
        performTransactionResult.getParameters().add(resultParam);

        performTransactionResult.setProviderTrnId(72);


        return performTransactionResult;
    }

    @Override
    public Transaction save(Transaction entity) {
        return transactionRepository.save(entity);
    }
}
