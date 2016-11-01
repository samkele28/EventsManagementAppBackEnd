package eventsystem.services.Impl;

import eventsystem.domain.EventType;
import eventsystem.repository.domain.EventTypeRepository;
import eventsystem.services.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samkele on 10/30/2016.
 */
public class EventTypeServiceImpl implements EventTypeService{
    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Override
    public EventType findById(Long Id) {
        return eventTypeRepository.findOne(Id);
    }

    @Override
    public EventType save(EventType eventType) {
        return eventTypeRepository.save(eventType);
    }

    @Override
    public EventType update(EventType eventType) {
        return eventTypeRepository.save(eventType);
    }

    @Override
    public void delete(EventType eventType) {
        eventTypeRepository.delete(eventType);
    }

    @Override
    public List<EventType> findAll() {
        List<EventType> allEventTypes = new ArrayList<>();
        Iterable<EventType> eventTypes = eventTypeRepository.findAll();
        for (EventType eventType : eventTypes) {
            allEventTypes.add(eventType);
        }
        return allEventTypes;
    }
}
