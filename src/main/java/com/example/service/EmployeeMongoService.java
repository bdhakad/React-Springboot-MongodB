package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.models.Employee;
import com.example.repositories.EmployeeMongoRepository;

@Service
public class EmployeeMongoService implements AbstractEmployeeService {
	
	@Autowired
	private EmployeeMongoRepository employeeMongoRepository;
	
	public List<Employee> findAll() {
		
		return employeeMongoRepository.findAll();
	}
	
	public boolean existsById(String id) {
		return employeeMongoRepository.existsById(id);
	}
	
    public Employee save(Employee employee) {
		return employeeMongoRepository.save(employee);
	}
    
    public Employee insert(Employee employee) {
		return employeeMongoRepository.insert(employee);
	}
    
    public void delete(Employee employee) {
    	employeeMongoRepository.delete(employee);
    }

	public List<Employee> findByFirstName(String firstName) {
		return employeeMongoRepository.findByFirstName(firstName);
	}

	public List<Employee> findByLastName(String lastName) {
		return employeeMongoRepository.findByLastName(lastName);
	}

	public List<Employee> findByDescription(String description) {
		return employeeMongoRepository.findByDescription(description);
	}

	@Override
	public Optional<Employee> findById(Long id) {
		return employeeMongoRepository.findById(id);
	}
}
