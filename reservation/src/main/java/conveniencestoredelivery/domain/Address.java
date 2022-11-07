package conveniencestoredelivery.domain;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Embeddable
@Data
public class Address {




    @Column(name = "street", insertable = false, updatable = false)
    private String street;


    @Column(name = "city", insertable = false, updatable = false)
    private String city;


    @Column(name = "state", insertable = false, updatable = false)
    private String state;


    @Column(name = "country", insertable = false, updatable = false)
    private String country;


    @Column(name = "zipcode", insertable = false, updatable = false)
    private String zipcode;



}

