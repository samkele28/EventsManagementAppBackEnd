package eventsystem.API;

import eventsystem.domain.Employee;
import eventsystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by Samkele on 8/29/2016.
 */
@RestController
@RequestMapping
public class EmployeePage {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee/", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> ListAllEmployees(){
        List<Employee> employees = employeeService.findAll();
        if(employees.isEmpty())
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{empId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable("empId") long empId){
        System.out.println("Fetching Employee with ID " + empId);
        Employee employee = employeeService.findById(empId);
        if(employee == null) {
            System.out.println("Employee with ID " + empId + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createEmployee(@RequestBody Employee employee, UriComponentsBuilder ucBuilder){
        System.out.println("Creating Employee " + employee.getFirstName());

        employeeService.save(employee);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/employee/{empId}").buildAndExpand(employee.getEmpId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employee/update/{empId}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long empId, @RequestBody Employee employee){
        System.out.println("Updating Employee " + empId);

        Employee currentEmployee = employeeService.findById(empId);

        if(currentEmployee == null){
            System.out.println("Employee with ID " + empId + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        Employee updatedEmployee = new Employee
                .Builder()
                .copy(currentEmployee)
                .employeeNumber(currentEmployee.getEmployeeNumber())
                .firstName(currentEmployee.getFirstName())
                .lastName(currentEmployee.getLastName())
                .build();
        employeeService.update(updatedEmployee);
        return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/delete/{empId}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("empId") long empId){
        System.out.println("Fetching & Deleting Employee with ID " + empId);

        Employee employee = employeeService.findById(empId);
        if(employee == null){
            System.out.println("Unable to delete. Employee with ID " + empId + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        employeeService.delete(employee);
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }
}
