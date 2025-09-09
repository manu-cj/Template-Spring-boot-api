package com.manu.template.service;

import com.manu.template.dto.PaymentDTO;
import com.manu.template.model.Payment;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.StringReader;
import java.io.StringWriter;

@Service
public class PaymentXmlService {

    public String toXml(PaymentDTO paymentDTO) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(PaymentDTO.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter writer = new StringWriter();
        marshaller.marshal(paymentDTO, writer);
        return writer.toString();
    }

    public PaymentDTO fromXml(String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(PaymentDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (PaymentDTO) unmarshaller.unmarshal(new StringReader(xml));
    }
}
