package com.example.taskwebservice.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapWebService  extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean create(ApplicationContext context){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet,"/accountWS/*");
    }

    @Bean
    public XsdSchema accountSchema(){
        return new SimpleXsdSchema(new ClassPathResource("ProviderWebService.xsd"));
    }

    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition (XsdSchema schema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(schema);
        definition.setLocationUri("/accountWS");
        definition.setPortTypeName("AccountServicePort");
        definition.setTargetNamespace("http://uws.provider.com/");
        return definition;
    }
}
