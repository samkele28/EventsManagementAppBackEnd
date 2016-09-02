package eventsystem.factory;

import eventsystem.domain.EventAddress;

/**
 * Created by Samkele on 4/22/2016.
 */
public class EventAddressFactory {
    public static EventAddress getAddress(String streetAddress, String surburb, String postalCode) {
        EventAddress eventAddress = new EventAddress
                .Builder()
                .streetAddress(streetAddress)
                .surburb(surburb)
                .postalCode(postalCode)
                .build();
        return eventAddress;
    }
}
