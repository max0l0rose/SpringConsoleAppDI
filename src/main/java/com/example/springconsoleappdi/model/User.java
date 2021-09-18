package com.example.springconsoleappdi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
@SequenceGenerator(name = "sequence1", sequenceName = "mySequence1")
public class User extends BaseEntity {

	@Column(length = 100, columnDefinition = "varchar(50) default 'qqq'")
	String username;

	@OneToOne
	public Department department;

	//@Enumerated
	Role role;
}
