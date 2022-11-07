package conveniencestoredelivery.domain;

import conveniencestoredelivery.domain.*;
import conveniencestoredelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Returned extends AbstractEvent {

    private String status;
    private Long paecelId;
    private Integer customerId;
    private Long deliveryId;
    private Long invoicedId;
    private Long timestamp;
}
