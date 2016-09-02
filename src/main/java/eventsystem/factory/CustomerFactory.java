package eventsystem.factory;

import eventsystem.domain.Customer;

/**
 * Created by Samkele on 8/27/2016.
 */
public class CustomerFactory {
    public static Customer createCustomer(String customerName, String contactLastName, String contactNumber){
        Customer customer = new Customer
                .Builder()
                .customerName(customerName)
                .contactLastName(contactLastName)
                .contactNumber(contactNumber)
                .build();
        return customer;
    }
}
