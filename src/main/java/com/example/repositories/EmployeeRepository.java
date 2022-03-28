package com.example.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.models.Employee;

@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    List<Employee> findByFirstName(@Param("firstName") String firstName);
    List<Employee> findByLastName(@Param("lastName") String lastName);
    List<Employee> findByDescription(@Param("description") String description);
    Optional<Employee> findById(Long id);
    
}