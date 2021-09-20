package com.example.springconsoleappdi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
@SequenceGenerator(name = "sequenceGen", sequenceName = "seqUser", allocationSize = 1, initialValue = 1)
public class User extends BaseEntity {

	@NotNull
	@Column(length = 100, columnDefinition = "varchar(50) default 'qqq'")
	String username;

	@OneToOne
	public Department department;

	//@Basic(optional = false)

	//@Enumerated
	Role role;
}
