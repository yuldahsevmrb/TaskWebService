package com.example.taskwebservice.service;

import com.example.taskwebservice.domains.Client;
import com.example.taskwebservice.dto.GetInformationArguments;
import com.example.taskwebservice.dto.GetInformationResult;

import javax.xml.bind.JAXBElement;
import java.util.Optional;


public interface ClientService {
    GetInformationResult getClient(JAXBElement<GetInformationArguments> arguments);
    Optional<Client> getClient(String clientId);
}
