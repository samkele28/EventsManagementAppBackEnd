package eventsystem.repository.domain;

import eventsystem.domain.Event;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Samkele on 8/28/2016.
 */
public interface EventRepository extends CrudRepository<Event, Long> {
}
