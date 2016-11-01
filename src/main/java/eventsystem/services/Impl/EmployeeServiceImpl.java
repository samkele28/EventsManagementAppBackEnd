package eventsystem.services.Impl;

import eventsystem.domain.Employee;
import eventsystem.repository.domain.EmployeeRepository;
import eventsystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samkele on 10/30/2016.
 */
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee findById(Long Id) {
        return employeeRepository.findOne(Id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> allEmployees = new ArrayList<>();
        Iterable<Employee> employees = employeeRepository.findAll();
        for (Employee employee : employees) {
            allEmployees.add(employee);
        }
        return allEmployees;
    }
}
