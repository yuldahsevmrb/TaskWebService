package com.example.taskwebservice.service;

import com.example.taskwebservice.domains.Account;
import com.example.taskwebservice.domains.Client;
import com.example.taskwebservice.repository.AccountRepository;
import com.example.taskwebservice.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService{

    //TODO need to implement to add amount into balance of account
    @Override
    public Account updateAccount(Client client, long amount) {

        BigDecimal result = client.getAccount().getBalance().add(BigDecimal.valueOf(amount));
        client.getAccount().setBalance(result);


        return client.getAccount();
    }
}
