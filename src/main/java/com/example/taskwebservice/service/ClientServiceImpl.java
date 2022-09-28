package com.example.taskwebservice.service;


import com.example.taskwebservice.domains.Client;
import com.example.taskwebservice.dto.GenericParam;
import com.example.taskwebservice.dto.GetInformationArguments;
import com.example.taskwebservice.dto.GetInformationResult;
import com.example.taskwebservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBElement;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {



    @Autowired
    public ClientRepository clientRepository;

    @Override
    public GetInformationResult getClient(JAXBElement<GetInformationArguments> arguments) {
        GetInformationResult result = new GetInformationResult();
        for (GenericParam param: arguments.getValue().getParameters()) {
                    if(param.getParamKey().equalsIgnoreCase("client_id")){
                        Optional<Client> client = clientRepository.findById(Long.parseLong(param.getParamValue()));
                        if(client.isPresent()){
                            Client client1 = client.get();
                            GenericParam resultParam = new GenericParam();
                            resultParam.setParamKey("balance");
                            resultParam.setParamValue(String.valueOf(client1.getAccount().getBalance()));
                            result.getParameters().add(resultParam);
                            resultParam = new GenericParam();
                            resultParam.setParamKey("name");
                            resultParam.setParamValue(client1.getName());
                            result.getParameters().add(resultParam);
                            result.setStatus(0);
                        }else{
                            System.out.println("not found");
                            result.setStatus(1);
                            result.setErrorMsg("NOT data found");
                        }
                    }
        }
        return result;
    }
}
