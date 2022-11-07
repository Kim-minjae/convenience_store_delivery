package conveniencestoredelivery.domain;

import conveniencestoredelivery.domain.*;
import conveniencestoredelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class InvoiceCanceled extends AbstractEvent {

    private Long invoiceId;
    private Long timestamp;
}


