package com.example.taskwebservice.dataloader;

import com.example.taskwebservice.domains.Account;
import com.example.taskwebservice.domains.Client;
import com.example.taskwebservice.repository.AccountRepository;
import com.example.taskwebservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        Client client = new Client();

        account.setActive(true);
        account.setBalance(BigDecimal.valueOf(10000));
        account.setNumber("12345678901234567891");

        client.setName("Test client name");
        client.setPhoneNumber("+998900050505");
        account =  accountRepository.save(account);
        client.setAccount(account);
        account.setClient(client);

        clientRepository.save(client);
        accountRepository.save(account);

    }
}


