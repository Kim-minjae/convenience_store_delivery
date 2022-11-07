package conveniencestoredelivery.domain;

import conveniencestoredelivery.domain.*;
import conveniencestoredelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class InvoiceIssued extends AbstractEvent {

    private Long invoiceId;
    private Long reversationId;
    private Integer customerId;
    private Long parcelId;
    private Address senderAddress;
    private String senderPhoneNumber;
    private Address receiverAddress;
    private String receiverPhoneNumber;
    private Date dueDate;
    private Long timestamp;

    public InvoiceIssued(Invoice aggregate){
        super(aggregate);
    }
    public InvoiceIssued(){
        super();
    }
}
