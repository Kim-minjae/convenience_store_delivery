package conveniencestoredelivery.domain;

import conveniencestoredelivery.domain.InboundCompleted;
import conveniencestoredelivery.domain.LoadingCompleted;
import conveniencestoredelivery.WarehouseApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Parcel_table")
@Data

public class Parcel  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long parcelId;
    
    
    
    
    
    private String invoiceId;
    
    
    
    
    
    private Integer customerId;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private Date inboundTimeStamp;
    
    
    
    
    
    private Date outboundTimeStamp;

    @PostPersist
    public void onPostPersist(){


        InboundCompleted inboundCompleted = new InboundCompleted(this);
        inboundCompleted.publishAfterCommit();



        LoadingCompleted loadingCompleted = new LoadingCompleted(this);
        loadingCompleted.publishAfterCommit();

    }

    public static ParcelRepository repository(){
        ParcelRepository parcelRepository = WarehouseApplication.applicationContext.getBean(ParcelRepository.class);
        return parcelRepository;
    }




    public static void scheculeParcelInbound(InvoiceIssued invoiceIssued){

        repository().findById(Long.valueOf(invoiceIssued.getInvoiceId())).ifPresent(parcel -> {
            parcel.setStatus("inbounded");
            repository().save(parcel);
        });

        
    }
    //Compensation
    public static void cancelParcelInboundSchedule(InvoiceCanceled invoiceCanceled){

        repository().findById(Long.valueOf(invoiceCanceled.getInvoiceId())).ifPresent(parcel -> {
            parcel.setStatus("canceled");
            repository().save(parcel);
        });

    }


}
