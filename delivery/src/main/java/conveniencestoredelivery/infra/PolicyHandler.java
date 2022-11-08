package conveniencestoredelivery.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import conveniencestoredelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import conveniencestoredelivery.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired DeliveryRepository deliveryRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='InvoiceIssued'")
    public void wheneverInvoiceIssued_Gather(@Payload InvoiceIssued invoiceIssued){

        InvoiceIssued event = invoiceIssued;
        System.out.println("\n\n##### listener Gather : " + invoiceIssued + "\n\n");

        // Sample Logic //
        Delivery.gather(event);

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='InvoiceCanceled'")
    public void wheneverInvoiceCanceled_Return(@Payload InvoiceCanceled invoiceCanceled){

        InvoiceCanceled event = invoiceCanceled;
        System.out.println("\n\n##### listener Return : " + invoiceCanceled + "\n\n");


        

        // Sample Logic //
        Delivery.returns(event);
        

        

    }

}


