package org.sid.hrservicems.resources;

import org.sid.hrservicems.models.Employee;
import org.sid.hrservicems.models.EmployeesList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/hr")
public class HrResources {

    List<Employee> employees = Arrays.asList(
            new Employee("E1","Kindson","Munonye","MediTech"),
            new Employee("E2","Lila","Hardcasle","Surgery"),
            new Employee("E3","Solace","Chucks","Dentistry")
    );

    @RequestMapping("/employees")
    public EmployeesList getEmployees(){
        EmployeesList employeesList = new EmployeesList();
        employeesList.setEmployees(employees);
        return employeesList;
    }

    @RequestMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") String id){
        Employee returnedEmployee = employees.stream()
                .filter(employee -> id.equals(employee.getId()))
                .findAny()
                .orElse(null);
        return returnedEmployee;

    }
}
