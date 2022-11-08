package conveniencestoredelivery.infra;
import conveniencestoredelivery.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@RestController
@RequestMapping(value="/deliveries")
@Transactional
public class DeliveryController {
    @Autowired
    DeliveryRepository deliveryRepository;
    @GetMapping("/deliveryAvailable")
    public Delivery deliveryAvailableAddress() {

        int dice = (int)Math.random()*10;

        Delivery delivery = new Delivery();

        if(dice>4){
            delivery.setDeliveryId(10l);
            return delivery;
        } else {
            delivery.setDeliveryId(11l);
            return delivery;
        }
    }



}
