package com.example.springconsoleappdi.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

//@Entity // ERROR
//@Inheritance(strategy = InheritanceType.JOINED)
@Data
@MappedSuperclass
public class BaseEntity implements StringsArray {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sequenceGen")

//	@GeneratedValue(generator = "idSequence")
//	@SequenceGenerator(//schema = "MYORASCHEMA",
//			name = "idSequence",
//			sequenceName = "MY_ORACLE_SEQ_NAME",
//			allocationSize = 1)

	//@Column(name="ID")
	long id;

	@Column(columnDefinition = "integer default 0")
	int version;

	//@Temporal(TemporalType.TIMESTAMP) // ERROR
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
			updatable = false, insertable = false)
	//@Basic
	//@CreationTimestamp // hibernate
	//@Transient
	Instant created;

	@Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP",
			updatable = false, insertable = false)
	//@Temporal(TemporalType.TIMESTAMP) // ERROR
	//@UpdateTimestamp // hibernate
	Instant modified; //LocalDateTime


	public String[] toStringsArray() {
		return new String[] {String.valueOf(id), String.valueOf(created), String.valueOf(modified)};
	}

//	@Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
//	OffsetDateTime created_offsetDT;
}
