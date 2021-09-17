package com.example.springconsoleappdi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
public class User extends BaseEntity {

	@Column(length = 100, columnDefinition = "varchar(50) default 'qqq'")
	String username;

	@OneToOne
	public Department department;
}
