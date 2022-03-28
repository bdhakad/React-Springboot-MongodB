package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.models.Employee;
import com.example.service.EmployeeMongoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/employees", produces = "application/json", consumes = "application/json")
public class EmployeeController {

	@Autowired
	private EmployeeMongoService employeeMongoService;

	// health check
	@GetMapping(value = "/health")
	ResponseEntity<String> home() {
		return ResponseEntity.ok().body("{ \"message\" : \"Employee Service is up and running\"}");
	}

	// get employees
	@GetMapping(value = "/list")
	ResponseEntity<List<Employee>> getEmployeeByFirstName(
			@RequestParam(name = "firstName", required = false) String firstName,
			@RequestParam(name = "lastName", required = false) String lastName,
			@RequestParam(name = "description", required = false) String description) {

		List<Employee> result = new ArrayList<Employee>();
		if (firstName != null) {
			result = employeeMongoService.findByFirstName(firstName);
		} else if (lastName != null) {
			result = employeeMongoService.findByLastName(lastName);
		} else if (description != null) {
			result = employeeMongoService.findByDescription(description);
		} else {
			result = employeeMongoService.findAll();
		}
		if (result.size() <= 0) {
			return ResponseEntity.status(204).build();
		}

		return ResponseEntity.ok().body(result);
	}

	// add employee
	@PostMapping(value = "/add")
	ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
		Employee createdEmployee = employeeMongoService.insert(employee);
		if (createdEmployee != null && employeeMongoService.existsById(createdEmployee.getId())) {
			return ResponseEntity.status(HttpStatus.CREATED).body("{ \"message\" : \"Employee record created\"}");
		}
		return ResponseEntity.internalServerError().body("{ \"message\" : \"Employee record not created\"}");
	}

	// delete employee
	@DeleteMapping(value = "/delete")
	ResponseEntity<Object> deleteEmployee(@RequestBody Employee employee) {
		if (employeeMongoService.existsById(employee.getId())) {
			employeeMongoService.delete(employee);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("{ \"message\" : \"Employee record deleted\"}");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{ \"message\" : \"Employee record doesn't exist\"}");
		}
	}

	// update employee
	@PatchMapping(value = "/update")
	ResponseEntity<Object> updateEmployee(@RequestBody Employee employee) {
		if (employeeMongoService.existsById(employee.getId())) {
			employeeMongoService.save(employee);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("{ \"message\" : \"Employee record updated\"}");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{ \"message\" : \"Employee record doesn't exist\"}");
		}
	}

	// update or create employee
	@PutMapping(value = "/updateOrcreate")
	ResponseEntity<Object> updateOrCreateEmployee(@RequestBody Employee employee) {
		if (employeeMongoService.existsById(employee.getId())) {
			employeeMongoService.save(employee);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("{ \"message\" : \"Employee record updated\"}");
		}

		Employee insertedEmployee = employeeMongoService.insert(employee);
		if (employeeMongoService.existsById(insertedEmployee.getId())) {
			return ResponseEntity.status(HttpStatus.CREATED).body("{ \"message\" : \"Employee record created\"}");
		}
		return ResponseEntity.internalServerError()
				.body("{ \"message\" : \"Error updaing or creating employee record.\"}");

	}
}
