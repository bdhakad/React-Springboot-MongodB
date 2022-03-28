package com.example.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document("Employee")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {
	@Id
	@Getter
	@Setter
	private String id;
	@Getter
	@Setter 
	private String firstName;
	@Getter
	@Setter
	private String lastName;
	@Getter
	@Setter
	private String description;
}