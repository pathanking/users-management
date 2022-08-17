package com.barclays.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "barclays_users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer uid;
	private String firstName;
	private String lastName;
	private String email;

	@Embedded
	private Address address;

}
