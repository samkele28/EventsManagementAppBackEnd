package eventsystem.repository;

import eventsystem.App;
import eventsystem.domain.Customer;
import eventsystem.factory.CustomerFactory;
import eventsystem.repository.domain.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Samkele on 9/2/2016.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCRUDCustomer extends AbstractTestNGSpringContextTests {
    private Long id;
    private Long custId;

    @Autowired
    CustomerRepository repository;

    @Test
    public void create() throws Exception {
        /*Map<String,String> values = new HashMap<String, String>();
        values.put("customerName", "Lusindiso");
        values.put("contactLastName", "Best");
        values.put("contactNumber", "0832784460");*/
        Customer customer = CustomerFactory.createCustomer("Lusindiso","Best","0832784460");
        repository.save(customer);
        custId = customer.getCustId();
        Assert.assertNotNull(customer.getCustId());

    }
}
