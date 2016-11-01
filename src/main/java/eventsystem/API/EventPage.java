package eventsystem.API;

import eventsystem.domain.Event;
import eventsystem.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by Samkele on 10/30/2016.
 */
@RestController
@RequestMapping
public class EventPage {
    @Autowired
    EventService eventService;

    @RequestMapping(value = "/event/", method = RequestMethod.GET)
    public ResponseEntity<List<Event>> ListAllEvents(){
        List<Event> events = eventService.findAll();
        if(events.isEmpty())
            return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
    }

    @RequestMapping(value = "/event/{eventId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> getEvent(@PathVariable("eventId") long eventId){
        System.out.println("Fetching Event with ID " + eventId);
        Event event = eventService.findById(eventId);
        if(event == null) {
            System.out.println("Event with ID " + eventId + " not found");
            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Event>(event, HttpStatus.OK);
    }

    @RequestMapping(value = "/event/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createEvent(@RequestBody Event event, UriComponentsBuilder ucBuilder){
        System.out.println("Creating Event " + event.getEventName());

        eventService.save(event);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/event/{eventId}").buildAndExpand(event.getEventId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/event/update/{eventId}", method = RequestMethod.PUT)
    public ResponseEntity<Event> updateEvent(@PathVariable("id") long eventId, @RequestBody Event event){
        System.out.println("Updating Event " + eventId);

        Event currentEvent = eventService.findById(eventId);

        if(currentEvent == null){
            System.out.println("Event with ID " + eventId + " not found");
            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
        }

        Event updatedEvent = new Event
                .Builder()
                .copy(currentEvent)
                .eventName(currentEvent.getEventName())
                .eventDescription(currentEvent.getEventDescription())
                .location(currentEvent.getLocation())
                .startDate(currentEvent.getStartDate())
                .startTime(currentEvent.getStartTime())
                .availableSpace(currentEvent.getAvailableSpace())
                .costPerPerson(currentEvent.getCostPerPerson())
                .emailAddress(currentEvent.getEmailAddress())
                .build();
        eventService.update(updatedEvent);
        return new ResponseEntity<Event>(updatedEvent, HttpStatus.OK);
    }

    @RequestMapping(value = "/event/delete/{eventId}", method = RequestMethod.DELETE)
    public ResponseEntity<Event> deleteEvent(@PathVariable("eventId") long eventId){
        System.out.println("Fetching & Deleting Event with ID " + eventId);

        Event event = eventService.findById(eventId);
        if(event == null){
            System.out.println("Unable to delete. Event with ID " + eventId + " not found");
            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
        }
        eventService.delete(event);
        return new ResponseEntity<Event>(HttpStatus.NO_CONTENT);
    }
}
