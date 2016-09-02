package eventsystem.factory;

import eventsystem.domain.CustomerAddress;

/**
 * Created by Samkele on 8/28/2016.
 */
public class CustomerAddressFactory {
    public static CustomerAddress getAddress(String streetAddress, String surburb, String postalCode) {
        CustomerAddress customerAddress = new CustomerAddress
                .Builder()
                .streetAddress(streetAddress)
                .surburb(surburb)
                .postalCode(postalCode)
                .build();
        return customerAddress;
    }
}
