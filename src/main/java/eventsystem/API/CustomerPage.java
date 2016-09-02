package eventsystem.API;

import eventsystem.domain.Customer;
import eventsystem.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by Samkele on 8/28/2016.
 */
@RestController
@RequestMapping
public class CustomerPage {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customer/", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> ListAllCustomers(){
        List<Customer> customers = customerService.findAll();
        if(customers.isEmpty())
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/{custId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("custId") long custId){
        System.out.println("Fetching Customer with ID " + custId);
        Customer customer = customerService.findById(custId);
        if(customer == null) {
            System.out.println("Customer with ID " + custId + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer, UriComponentsBuilder ucBuilder){
        System.out.println("Creating Customer " + customer.getCustomerName());

        customerService.save(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/customer/{custId}").buildAndExpand(customer.getCustId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/customer/update/{custId}", method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long custId, @RequestBody Customer customer){
        System.out.println("Updating Customer " + custId);

        Customer currentCustomer = customerService.findById(custId);

        if(currentCustomer == null){
            System.out.println("Customer with ID " + custId + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        Customer updatedCustomer = new Customer
                .Builder()
                .copy(currentCustomer)
                .customerName(currentCustomer.getCustomerName())
                .contactLastName(currentCustomer.getContactLastName())
                .contactNumber(currentCustomer.getContactNumber())
                .build();
        customerService.update(updatedCustomer);
        return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/delete/{custId}", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("custId") long custId){
        System.out.println("Fetching & Deleting Customer with ID " + custId);

        Customer customer = customerService.findById(custId);
        if(customer == null){
            System.out.println("Unable to delete. Customer with ID " + custId + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        customerService.delete(customer);
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }

}
