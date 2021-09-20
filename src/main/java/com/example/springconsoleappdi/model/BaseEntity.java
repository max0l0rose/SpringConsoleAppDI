package com.example.springconsoleappdi.model;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

//@Entity // ERROR
//@Inheritance(strategy = InheritanceType.JOINED)
@Data
@MappedSuperclass
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGen")

//	@GeneratedValue(generator = "idSequence")
//	@SequenceGenerator(//schema = "MYORASCHEMA",
//			name = "idSequence",
//			sequenceName = "MY_ORACLE_SEQ_NAME",
//			allocationSize = 1)

	//@Column(name="ID")
	long id;

	@Column(columnDefinition = "integer default 0")
	int version;

	@Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	Instant created;

	@Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	Instant modified; //LocalDateTime

//	@Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
//	OffsetDateTime created_offsetDT;
}
