package eventsystem.factory;

import eventsystem.domain.Event;

import java.util.Date;

/**
 * Created by Samkele on 4/26/2016.
 */
public class EventFactory {
    public static Event createEvent(String name, String description, Date date){
        Event event = new Event
                .Builder()
                .eventName(name)
                .eventDescription(description)
                .startDate(date)
                .build();
        return event;
    }
}
