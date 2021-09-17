package com.example.springconsoleappdi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
public class Department extends BaseEntity {

	@Column(length = 50)
	String depName;
}


