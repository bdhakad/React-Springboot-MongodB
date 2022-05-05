package com.example.loader;

import com.example.models.Employee;
import com.example.repositories.EmployeeMongoRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {
    @Bean
    CommandLineRunner commandLineRunner(EmployeeMongoRepository employeeMongoRepository) {
        return strings -> {
        	employeeMongoRepository.save(new Employee("Alvin", "Ryan", "description1"));
        	employeeMongoRepository.save(new Employee("Ryson", "Reid", "description2"));
        };
    }
}
