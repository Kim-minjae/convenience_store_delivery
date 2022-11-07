package conveniencestoredelivery.domain;

import conveniencestoredelivery.domain.Gathered;
import conveniencestoredelivery.domain.CvsDeliveryCompleted;
import conveniencestoredelivery.domain.DeliveryCompleted;
import conveniencestoredelivery.domain.Returned;
import conveniencestoredelivery.DeliveryApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long deliveryId;
    
    
    
    @Embedded
    
    private Address receiverAddress;
    
    
    
    
    
    private Date dueDate;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private Long paecelId;
    
    
    
    
    
    private String receiverPhoneNumber;
    
    
    
    @Embedded
    
    private Address senderAddress;
    
    
    
    
    
    private String senderPhoneNumber;
    
    
    
    
    
    private Long reservationId;
    
    
    
    
    
    private Integer customerId;
    
    
    
    
    
    private Long invoicedId;
    
    
    
    
    
    private Long timestamp;

    @PostPersist
    public void onPostPersist(){


        Gathered gathered = new Gathered(this);
        gathered.publishAfterCommit();



        CvsDeliveryCompleted cvsDeliveryCompleted = new CvsDeliveryCompleted(this);
        cvsDeliveryCompleted.publishAfterCommit();



        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();



        Returned returned = new Returned(this);
        returned.publishAfterCommit();

    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }




    public static void gather(InvoiceIssued invoiceIssued){

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(invoiceIssued.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }
    public static void returns(InvoiceCanceled invoiceCanceled){


        Delivery delivery = new Delivery();
        repository().save(delivery);


        /** Example 2:  finding and process
        
        repository().findById(invoiceCanceled.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }


}
