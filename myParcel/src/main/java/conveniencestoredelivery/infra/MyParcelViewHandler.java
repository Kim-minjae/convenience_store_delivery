package conveniencestoredelivery.infra;

import conveniencestoredelivery.domain.*;
import conveniencestoredelivery.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyParcelViewHandler {


    @Autowired
    private MyParcelRepository myParcelRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservered_then_CREATE_1 (@Payload Reservered reservered) {
        try {

            if (!reservered.validate()) return;

            // view 객체 생성
            MyParcel myParcel = new MyParcel();
            // view 객체에 이벤트의 Value 를 set 함
            myParcel.setReservationId(reservered.getReservationId());
            myParcel.setCustomerId(reservered.getCustomerId());
            myParcel.setUpdateTimeStamp(reservered.getReservedTimestamp());
            myParcel.setReceiverAddress(String.valueOf(reservered.getReceiverAddress()));
            // view 레파지 토리에 save
            myParcelRepository.save(myParcel);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenInvoiceIssued_then_UPDATE_1(@Payload InvoiceIssued invoiceIssued) {
        try {
            if (!invoiceIssued.validate()) return;
                // view 객체 조회

                List<MyParcel> myParcelList = myParcelRepository.findByReservationId(invoiceIssued.getReversationId());
                for(MyParcel myParcel : myParcelList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myParcel.setInvoiceId(invoiceIssued.getInvoiceId());
                    myParcel.setStatus("InvoiceIssued");
                    myParcel.setSenderAddress(String.valueOf(invoiceIssued.getSenderAddress()));
                    myParcel.setDueDate(String.valueOf(invoiceIssued.getDueDate()));
                    myParcel.setUpdateTimeStamp(invoiceIssued.getTimestamp());
                // view 레파지 토리에 save
                myParcelRepository.save(myParcel);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenInvoiceCanceled_then_UPDATE_2(@Payload InvoiceCanceled invoiceCanceled) {
        try {
            if (!invoiceCanceled.validate()) return;
                // view 객체 조회

                List<MyParcel> myParcelList = myParcelRepository.findByInvoiceId(invoiceCanceled.getInvoiceId());
                for(MyParcel myParcel : myParcelList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myParcel.setStatus("InvoiceCancled");
                // view 레파지 토리에 save
                myParcelRepository.save(myParcel);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReturned_then_UPDATE_3(@Payload Returned returned) {
        try {
            if (!returned.validate()) return;
                // view 객체 조회

                List<MyParcel> myParcelList = myParcelRepository.findByInvoiceId(returned.getInvoicedId());
                for(MyParcel myParcel : myParcelList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myParcel.setUpdateTimeStamp(returned.getTimestamp());
                    myParcel.setStatus(returned.getStatus());
                // view 레파지 토리에 save
                myParcelRepository.save(myParcel);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenGathered_then_UPDATE_4(@Payload Gathered gathered) {
        try {
            if (!gathered.validate()) return;
                // view 객체 조회

                List<MyParcel> myParcelList = myParcelRepository.findByInvoiceId(gathered.getInvoicedId());
                for(MyParcel myParcel : myParcelList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myParcel.setStatus("Gathered");
                    myParcel.setUpdateTimeStamp(gathered.getTimestamp());
                // view 레파지 토리에 save
                myParcelRepository.save(myParcel);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCvsDeliveryCompleted_then_UPDATE_5(@Payload CvsDeliveryCompleted cvsDeliveryCompleted) {
        try {
            if (!cvsDeliveryCompleted.validate()) return;
                // view 객체 조회

                List<MyParcel> myParcelList = myParcelRepository.findByInvoiceId(cvsDeliveryCompleted.getInvoicedId());
                for(MyParcel myParcel : myParcelList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myParcel.setStatus("cvsDeliveryCompleted");
                    myParcel.setUpdateTimeStamp(cvsDeliveryCompleted.getTimestamp());
                // view 레파지 토리에 save
                myParcelRepository.save(myParcel);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCompleted_then_UPDATE_6(@Payload DeliveryCompleted deliveryCompleted) {
        try {
            if (!deliveryCompleted.validate()) return;
                // view 객체 조회

                List<MyParcel> myParcelList = myParcelRepository.findByInvoiceId(deliveryCompleted.getInvoicedId());
                for(MyParcel myParcel : myParcelList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myParcel.setStatus("deleveryCompleted");
                    myParcel.setUpdateTimeStamp(deliveryCompleted.getTimestamp());
                // view 레파지 토리에 save
                myParcelRepository.save(myParcel);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenInboundCompleted_then_UPDATE_7(@Payload InboundCompleted inboundCompleted) {
        try {
            if (!inboundCompleted.validate()) return;
                // view 객체 조회

                List<MyParcel> myParcelList = myParcelRepository.findByInvoiceId(Long.valueOf(inboundCompleted.getInvoiceId()));
                for(MyParcel myParcel : myParcelList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myParcel.setStatus(inboundCompleted.getStatus());
                    myParcel.setMyparcelId(inboundCompleted.getParcelId());
                    myParcel.setUpdateTimeStamp(inboundCompleted.getInboundTimeStamp());
                // view 레파지 토리에 save
                myParcelRepository.save(myParcel);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenLoadingCompleted_then_UPDATE_8(@Payload LoadingCompleted loadingCompleted) {
        try {
            if (!loadingCompleted.validate()) return;
                // view 객체 조회

                List<MyParcel> myParcelList = myParcelRepository.findByInvoiceId(Long.valueOf(loadingCompleted.getInvoiceId()));
                for(MyParcel myParcel : myParcelList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    myParcel.setStatus(loadingCompleted.getStatus());
                    myParcel.setUpdateTimeStamp(loadingCompleted.getOutboundTimeStamp());
                // view 레파지 토리에 save
                myParcelRepository.save(myParcel);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenInvoiceCanceled_then_DELETE_1(@Payload InvoiceCanceled invoiceCanceled) {
        try {
            if (!invoiceCanceled.validate()) return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

