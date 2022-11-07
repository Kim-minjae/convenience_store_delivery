package conveniencestoredelivery.domain;

import conveniencestoredelivery.domain.InvoiceIssued;
import conveniencestoredelivery.domain.InvoiceCanceled;
import conveniencestoredelivery.ReservationApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Invoice_table")
@Data

public class Invoice  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long invoiceId;
    
    
    
    
    
    private Long reversationId;
    
    
    
    
    
    private Integer customerId;
    
    
    
    
    
    private Long parcelId;
    
    
    
    @Embedded
    
    private Address senderAddress;
    
    
    
    
    
    private String senderPhoneNumber;
    
    
    
    @Embedded
    
    private Address receiverAddress;
    
    
    
    
    
    private String receiverPhoneNumber;
    
    
    
    
    
    private Date dueDate;
    
    
    
    
    
    private Long timestamp;

    @PostPersist
    public void onPostPersist(){


        InvoiceIssued invoiceIssued = new InvoiceIssued(this);
        invoiceIssued.publishAfterCommit();



        InvoiceCanceled invoiceCanceled = new InvoiceCanceled(this);
        invoiceCanceled.publishAfterCommit();

    }

    public static InvoiceRepository repository(){
        InvoiceRepository invoiceRepository = ReservationApplication.applicationContext.getBean(InvoiceRepository.class);
        return invoiceRepository;
    }






}
