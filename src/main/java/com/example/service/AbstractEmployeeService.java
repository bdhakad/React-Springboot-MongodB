package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.models.Employee;

/**
 * @author brajeshdhakad
 *
 */
public interface AbstractEmployeeService {
	Optional<Employee> findById(Long id);

	List<Employee> findByFirstName(String firstName);
}
