package eventsystem.services.Impl;

import eventsystem.domain.CustomerAddress;
import eventsystem.repository.domain.CustomerAddressRepository;
import eventsystem.services.CustomerAddressService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samkele on 10/30/2016.
 */
public class CustomerAddressServiceImpl implements CustomerAddressService {
    @Autowired
    private CustomerAddressRepository customerAddressRepository;

    @Override
    public CustomerAddress findById(Long Id) {
        return customerAddressRepository.findOne(Id);
    }

    @Override
    public CustomerAddress save(CustomerAddress customerAddress) {
        return customerAddressRepository.save(customerAddress);
    }

    @Override
    public CustomerAddress update(CustomerAddress customerAddress) {
        return customerAddressRepository.save(customerAddress);
    }

    @Override
    public void delete(CustomerAddress customerAddress) {
        customerAddressRepository.delete(customerAddress);
    }

    @Override
    public List<CustomerAddress> findAll() {
        List<CustomerAddress> allCustomerAddresses = new ArrayList<>();
        Iterable<CustomerAddress> customerAddresses = customerAddressRepository.findAll();
        for (CustomerAddress customerAddress : customerAddresses) {
            allCustomerAddresses.add(customerAddress);
        }
        return allCustomerAddresses;
    }
}
