package com.example.springconsoleappdi.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

//@Entity // ERROR
//@Inheritance(strategy = InheritanceType.JOINED)
@Data
@MappedSuperclass
public class BaseEntity {

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)

//	@GeneratedValue(generator = "idSequence")
//	@SequenceGenerator(//schema = "MYORASCHEMA",
//			name = "idSequence",
//			sequenceName = "MY_ORACLE_SEQ_NAME",
//			allocationSize = 1)

	@Column(name="ID")
	long id;

	@Column(columnDefinition = "integer default 0")
	int version;

	Time qqq;
}
