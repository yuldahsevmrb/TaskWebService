//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.09.27 at 08:28:01 PM UZT 
//


package com.example.taskwebservice.dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetInformationResult", propOrder = {
    "parameters"
})
public class GetInformationResult
    extends GenericResult
{

    @XmlElement(nillable = true)
    protected List<GenericParam> parameters;


    public List<GenericParam> getParameters() {
        if (parameters == null) {
            parameters = new ArrayList<GenericParam>();
        }
        return this.parameters;
    }

}
