package eventsystem.factory;

import eventsystem.domain.Employee;
//import java.util.UUID;
/**
 * Created by Samkele on 4/20/2016.
 */
public class EmployeeFactory {
    public static Employee createEmployee(String firstName, String lastName, String employeeNumber){
        Employee employee = new Employee
                .Builder()
                .firstName(firstName)
                .lastName(lastName)
                .employeeNumber(employeeNumber)
                .build();
        return employee;
    }

}
