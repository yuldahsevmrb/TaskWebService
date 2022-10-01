package com.example.taskwebservice.endpoint;

import com.example.taskwebservice.domains.Transaction;
import com.example.taskwebservice.dto.*;
import com.example.taskwebservice.service.ClientServiceImpl;
import com.example.taskwebservice.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.Collections;

@Endpoint
public class AccountEndPoint {

    @Autowired
    ClientServiceImpl clientService;

    @Autowired
    TransactionServiceImpl transactionService;

@PayloadRoot(namespace = "http://uws.provider.com/", localPart = "GetInformationArguments")
@ResponsePayload
public JAXBElement<GetInformationResult> getInformationResult(@RequestPayload JAXBElement<GetInformationArguments> arguments){
    return  new JAXBElement<GetInformationResult>(
            QName.valueOf("GetInformationResult"),
            GetInformationResult.class,
            null,
            clientService.getClient(arguments));

}

@PayloadRoot(namespace = "http://uws.provider.com/", localPart = "PerformTransactionArguments")
@ResponsePayload
public JAXBElement<PerformTransactionResult> performTransactionArguments(@RequestPayload JAXBElement<PerformTransactionArguments> arguments){
    return new JAXBElement<PerformTransactionResult>(QName.valueOf("PerformTransactionResult"),
                    PerformTransactionResult.class,
                    null,transactionService.addPayment(arguments));
}
}


