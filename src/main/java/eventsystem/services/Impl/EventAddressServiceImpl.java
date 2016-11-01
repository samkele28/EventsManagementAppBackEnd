package eventsystem.services.Impl;

import eventsystem.domain.EventAddress;
import eventsystem.repository.domain.EventAddressRepository;
import eventsystem.services.EventAddressService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samkele on 10/30/2016.
 */
public class EventAddressServiceImpl implements EventAddressService{
    @Autowired
    private EventAddressRepository eventAddressRepository;

    @Override
    public EventAddress findById(Long Id) {
        return eventAddressRepository.findOne(Id);
    }

    @Override
    public EventAddress save(EventAddress eventAddress) {
        return eventAddressRepository.save(eventAddress);
    }

    @Override
    public EventAddress update(EventAddress eventAddress) {
        return eventAddressRepository.save(eventAddress);
    }

    @Override
    public void delete(EventAddress eventAddress) {
        eventAddressRepository.delete(eventAddress);
    }

    @Override
    public List<EventAddress> findAll() {
        List<EventAddress> allEvents = new ArrayList<>();
        Iterable<EventAddress> events = eventAddressRepository.findAll();
        for (EventAddress event : events) {
            allEvents.add(event);
        }
        return allEvents;
    }
}
