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

import java.util.Optional;


//CQRS
@Service
@Transactional
public class PolicyHandler{
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Reservered'")
    public void wheneverReservered_UpdateState(@Payload Reservered reservered){

        Reservered event = reservered;
        System.out.println("\n\n##### listener UpdateState : " + reservered + "\n\n");

        // Sample Logic //
        try{
            if(!reservered.validate()) return;
            MyParcel.reserved(event);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryCompleted'")
    public void wheneverDeliveryCompleted_UpdateState(@Payload DeliveryCompleted deliveryCompleted){

        DeliveryCompleted event = deliveryCompleted;
        System.out.println("\n\n##### listener UpdateState : " + deliveryCompleted + "\n\n");


        // Sample Logic //
        try {
            if(!deliveryCompleted.validate()) return;
            MyParcel.delivered(deliveryCompleted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Gathered'")
    public void wheneverGathered_UpdateState(@Payload Gathered gathered){

        Gathered event = gathered;
        System.out.println("\n\n##### listener UpdateState : " + gathered + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Returned'")
    public void wheneverReturned_UpdateState(@Payload Returned returned){

        Returned event = returned;
        System.out.println("\n\n##### listener UpdateState : " + returned + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='InboundCompleted'")
    public void wheneverInboundCompleted_UpdateState(@Payload InboundCompleted inboundCompleted){

        InboundCompleted event = inboundCompleted;
        System.out.println("\n\n##### listener UpdateState : " + inboundCompleted + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='LoadingCompleted'")
    public void wheneverLoadingCompleted_UpdateState(@Payload LoadingCompleted loadingCompleted){

        LoadingCompleted event = loadingCompleted;
        System.out.println("\n\n##### listener UpdateState : " + loadingCompleted + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='InvoiceIssued'")
    public void wheneverInvoiceIssued_UpdateState(@Payload InvoiceIssued invoiceIssued){

        InvoiceIssued event = invoiceIssued;
        System.out.println("\n\n##### listener UpdateState : " + invoiceIssued + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='InvoiceCanceled'")
    public void wheneverInvoiceCanceled_UpdateState(@Payload InvoiceCanceled invoiceCanceled){

        InvoiceCanceled event = invoiceCanceled;
        System.out.println("\n\n##### listener UpdateState : " + invoiceCanceled + "\n\n");


        

        // Sample Logic //

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CvsDeliveryCompleted'")
    public void wheneverCvsDeliveryCompleted_UpdateState(@Payload CvsDeliveryCompleted cvsDeliveryCompleted){

        CvsDeliveryCompleted event = cvsDeliveryCompleted;
        System.out.println("\n\n##### listener UpdateState : " + cvsDeliveryCompleted + "\n\n");


        

        // Sample Logic //

        

    }

}


