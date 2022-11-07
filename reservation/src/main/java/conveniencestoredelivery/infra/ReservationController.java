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
// @RequestMapping(value="/reservations")
@Transactional
public class ReservationController {
    @Autowired
    ReservationRepository reservationRepository;

    @PostMapping("/reservation")
    public void makeReservation(Sender sender) {
        Reservation reservation = new Reservation();

        reservation.setCustomerId(sender.getCustomerId());
        reservation.setReceiverPhoneNumber(sender.getReceiverPhoneNumber());
        reservation.setReceiverAddress(sender.getReceiverAddress());

        reservationRepository.save(reservation);

    }


}
