package com.example.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
// import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "Employee")
@Entity
//@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {
	public Employee(String firstName, String lastName, String description) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
	}
	
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

	// public String getId() {
	// 	return id;
	// }
	// public void setId(String id) {
	// 	this.id = id;
	// }
	// public String getFirstName() {
	// 	return firstName;
	// }
	// public void setFirstName(String firstName) {
	// 	this.firstName = firstName;
	// }
	// public String getLastName() {
	// 	return lastName;
	// }
	// public void setLastName(String lastName) {
	// 	this.lastName = lastName;
	// }
	// public String getDescription() {
	// 	return description;
	// }
	// public void setDescription(String description) {
	// 	this.description = description;
	// }
}