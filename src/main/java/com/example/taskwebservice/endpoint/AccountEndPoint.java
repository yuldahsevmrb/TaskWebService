package com.example.taskwebservice.endpoint;

import com.example.taskwebservice.dto.GenericParam;
import com.example.taskwebservice.dto.GetInformationArguments;
import com.example.taskwebservice.dto.GetInformationResult;
import com.example.taskwebservice.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

@Endpoint
public class AccountEndPoint {

    @Autowired
    ClientServiceImpl clientService;

@PayloadRoot(namespace = "http://uws.provider.com/", localPart = "GetInformationArguments")
@ResponsePayload
public JAXBElement<GetInformationResult> getInformationResult(@RequestPayload JAXBElement<GetInformationArguments> arguments){
    return  new JAXBElement<GetInformationResult>(
            QName.valueOf("GetInformationResult"),
            GetInformationResult.class,
            null,
            clientService.getClient(arguments));
}
}


