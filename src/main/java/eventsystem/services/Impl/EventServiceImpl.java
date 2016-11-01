package eventsystem.services.Impl;

import eventsystem.domain.Event;
import eventsystem.repository.domain.EventRepository;
import eventsystem.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samkele on 10/30/2016.
 */
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event findById(Long Id) {
        return eventRepository.findOne(Id);
    }

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event update(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void delete(Event event) {
        eventRepository.delete(event);
    }

    @Override
    public List<Event> findAll() {
        List<Event> allEvents = new ArrayList<>();
        Iterable<Event> events = eventRepository.findAll();
        for (Event event : events) {
            allEvents.add(event);
        }
        return allEvents;
    }
}
