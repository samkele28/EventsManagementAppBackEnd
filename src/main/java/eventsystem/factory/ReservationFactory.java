package eventsystem.factory;

import eventsystem.domain.Reservation;

/**
 * Created by Samkele on 4/29/2016.
 */
public class ReservationFactory {
    public static Reservation createEvent(String reserveDate, String depositDue, String amountPaid){
        Reservation reserve = new Reservation
                .Builder()
                //.reserveDate(reserveDate.toString())
                //.depositDue(depositDue)
                //.amountPaid(amountPaid)
                .build();
        return reserve;
    }
}
