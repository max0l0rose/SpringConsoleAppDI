package com.example.springconsoleappdi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
@SequenceGenerator(name = "sequence2", sequenceName = "mySequence2")
public class Department extends BaseEntity
{
	@Column(length = 50)
	String depName;
}


