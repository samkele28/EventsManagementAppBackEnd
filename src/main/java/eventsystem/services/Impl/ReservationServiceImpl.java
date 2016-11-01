package eventsystem.services.Impl;

import eventsystem.domain.Reservation;
import eventsystem.repository.domain.ReservationRepository;
import eventsystem.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samkele on 10/30/2016.
 */
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation findById(Long Id) {
        return reservationRepository.findOne(Id);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation update(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void delete(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

    @Override
    public List<Reservation> findAll() {
        List<Reservation> allReservations = new ArrayList<>();
        Iterable<Reservation> reservations = reservationRepository.findAll();
        for (Reservation reservation : reservations) {
            allReservations.add(reservation);
        }
        return allReservations;
    }
}
