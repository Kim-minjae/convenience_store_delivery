package conveniencestoredelivery.domain;

import conveniencestoredelivery.domain.*;
import conveniencestoredelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CvsDeliveryCompleted extends AbstractEvent {

    private String status;
    private Integer customerId;
    private Long deliveryId;
    private Long invoicedId;
    private Long timestamp;
}
