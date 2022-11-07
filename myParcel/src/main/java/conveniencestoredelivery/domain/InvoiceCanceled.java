package conveniencestoredelivery.domain;

import conveniencestoredelivery.domain.*;
import conveniencestoredelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class InvoiceCanceled extends AbstractEvent {

    private Long invoiceId;
    private Long timestamp;
}
