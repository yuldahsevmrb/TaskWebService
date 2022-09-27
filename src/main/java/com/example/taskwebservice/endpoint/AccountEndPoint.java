package com.example.taskwebservice.endpoint;

import com.example.taskwebservice.dto.GenericParam;
import com.example.taskwebservice.dto.GetInformationArguments;
import com.example.taskwebservice.dto.GetInformationResult;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;

@Endpoint
public class AccountEndPoint {

@PayloadRoot(namespace = "http://uws.provider.com/", localPart = "GetInformationArguments")
@ResponsePayload
public GetInformationResult getInformationResult(@RequestPayload GetInformationArguments arguments){

    GetInformationResult response = new GetInformationResult();
    response.getParameters().add(new GenericParam());
    return response;
}

}
