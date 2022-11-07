package conveniencestoredelivery.external;

import lombok.Data;
import java.util.Date;
@Data
public class Delivery {

    private Long deliveryId;
    private Object receiverAddress;
    private Date dueDate;
    private String status;
    private Long paecelId;
    private String receiverPhoneNumber;
    private Object senderAddress;
    private String senderPhoneNumber;
    private Long reservationId;
    private Integer customerId;
    private Long invoicedId;
    private Long timestamp;
}


