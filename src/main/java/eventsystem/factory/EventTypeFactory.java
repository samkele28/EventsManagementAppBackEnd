package eventsystem.factory;

import eventsystem.config.util.DomainState;
import eventsystem.domain.EventType;

/**
 * Created by Samkele on 5/14/2016.
 */
public class EventTypeFactory {
    public static EventType createEventType(String name){
        EventType eventType = new EventType
                .Builder()
                .eventTypeName(name)
                .status(DomainState.ACTIVE.name())
                .build();
        return eventType;
    }

}
