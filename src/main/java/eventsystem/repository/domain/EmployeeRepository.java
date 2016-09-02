package eventsystem.repository.domain;

import eventsystem.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Samkele on 8/28/2016.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
