package eventsystem.repository.domain;

import eventsystem.domain.EventAddress;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Samkele on 8/28/2016.
 */
public interface EventAddressRepository extends CrudRepository<EventAddress, Long> {
}
