package eventsystem.repository.domain;

import eventsystem.domain.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Samkele on 8/28/2016.
 */
public interface ReservationRepository extends CrudRepository<Reservation, Long>{
}
