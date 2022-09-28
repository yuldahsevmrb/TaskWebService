package com.example.taskwebservice.service;

import com.example.taskwebservice.dto.GetInformationArguments;
import com.example.taskwebservice.dto.GetInformationResult;

import javax.xml.bind.JAXBElement;

public interface ClientService {
    GetInformationResult getClient(JAXBElement<GetInformationArguments> arguments);
}
