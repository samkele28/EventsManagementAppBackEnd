package eventsystem.repository.domain;

import eventsystem.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Samkele on 8/27/2016.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
