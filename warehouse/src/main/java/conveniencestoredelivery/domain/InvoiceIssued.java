package conveniencestoredelivery.domain;

import conveniencestoredelivery.domain.*;
import conveniencestoredelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class InvoiceIssued extends AbstractEvent {

    private Long invoiceId;
    private Long reversationId;
    private Integer customerId;
    private Long parcelId;
    private Object senderAddress;
    private String senderPhoneNumber;
    private Object receiverAddress;
    private String receiverPhoneNumber;
    private Date dueDate;
    private Long timestamp;
}


