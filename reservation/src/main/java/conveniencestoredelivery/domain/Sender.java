package conveniencestoredelivery.domain;

import lombok.Data;

@Data
public class Sender {

    private int customerId;
    private String receiverPhoneNumber;
    private Address receiverAddress;

}
