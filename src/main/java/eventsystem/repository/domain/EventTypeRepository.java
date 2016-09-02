package eventsystem.repository.domain;

import eventsystem.domain.EventType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Samkele on 8/28/2016.
 */
public interface EventTypeRepository extends CrudRepository<EventType, Long> {
}
