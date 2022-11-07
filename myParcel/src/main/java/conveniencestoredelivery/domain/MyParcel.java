package conveniencestoredelivery.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;

import conveniencestoredelivery.MyParcelApplication;
import conveniencestoredelivery.infra.MyParcelRepository;
import lombok.Data;

@Entity
@Table(name="MyParcel_table")
@Data
public class MyParcel {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long myparcelId;
        private Long reservationId;
        private Long invoiceId;
        private Integer customerId;
        private Long deliveryId;
        private Long parcelId;
        private String status;
        private Long updateTimeStamp;
        private Object receiverAddress;
        private String senderAddress;
        private String dueDate;


        public static MyParcelRepository repository(){
                MyParcelRepository reservationRepository = MyParcelApplication.applicationContext.getBean(MyParcelRepository.class);
                return reservationRepository;
        }

        public static void reserved(Reservered reservered){
                MyParcel myParcel = new MyParcel();
                myParcel.setReservationId(reservered.getReservationId());
                myParcel.setCustomerId(reservered.getCustomerId());
                myParcel.setReceiverAddress(reservered.getReceiverAddress());
                myParcel.setDueDate(reservered.getDueDate());
                myParcel.setUpdateTimeStamp(System.currentTimeMillis());

                repository().save(myParcel);

        }

        public static void delivered(DeliveryCompleted deliveryCompleted){
                MyParcel myParcel = new MyParcel();
                myParcel.setDeliveryId(deliveryCompleted.getDeliveryId());
                myParcel.setCustomerId(deliveryCompleted.getCustomerId());
                myParcel.setInvoiceId(deliveryCompleted.getInvoicedId());

                repository().save(myParcel);

        }
}