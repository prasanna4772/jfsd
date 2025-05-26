package com.example.management.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.management.model.Employee;
import com.example.management.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // get all employess
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            return null;
        }
    }

    // add and update employee
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // delete employee
    public void deletEmployee(Integer id) {
        employeeRepository.deleteById(id);
        return;
    }
}
