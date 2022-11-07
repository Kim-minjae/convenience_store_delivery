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
    private Object receiverAddress;
    private String receiverPhoneNumber;
    private Date dueDate;
    private Long reservationId;
}
