package com.example.taskwebservice.service;

import com.example.taskwebservice.domains.Account;
import com.example.taskwebservice.domains.Client;
import com.example.taskwebservice.repository.TransactionRepository;

public interface AccountService  {
    Account updateAccount(Client client, long amount);


}
