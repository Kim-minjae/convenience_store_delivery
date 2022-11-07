package conveniencestoredelivery.domain;

import conveniencestoredelivery.domain.*;
import conveniencestoredelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Gathered extends AbstractEvent {

    private Integer customerId;
    private String status;
    private Long deliveryId;
    private Long invoicedId;
    private Long timestamp;
}
