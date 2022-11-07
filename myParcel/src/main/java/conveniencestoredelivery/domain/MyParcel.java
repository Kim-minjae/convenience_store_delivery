package conveniencestoredelivery.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
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
        private String receiverAddress;
        private String senderAddress;
        private String dueDate;


}