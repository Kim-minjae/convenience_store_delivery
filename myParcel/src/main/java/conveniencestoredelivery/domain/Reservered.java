package conveniencestoredelivery.domain;

import conveniencestoredelivery.domain.*;
import conveniencestoredelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Reservered extends AbstractEvent {

    private Integer customerId;
    private Long reservedTimestamp;
    private String receiverAddress;
    private String receiverPhoneNumber;
    private String dueDate;
    private Long reservationId;
}
