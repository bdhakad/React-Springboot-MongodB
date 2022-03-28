package com.example.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

import com.example.models.Employee;

public interface EmployeeMongoRepository extends MongoRepository<Employee, String> {
    List<Employee> findAll();
     
    boolean existsById(String id);
    
    Optional<Employee> findById(String id);

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    List<Employee> findByDescription(String description);

    Employee save(Employee employee);

    Employee insert(Employee employee);

    void delete(Employee employee);

    Optional<Employee> findById(Long id);

}
