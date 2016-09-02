package eventsystem.repository.domain;

import eventsystem.domain.CustomerAddress;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Samkele on 8/28/2016.
 */
public interface CustomerAddressRepository extends CrudRepository<CustomerAddress, Long> {
}
