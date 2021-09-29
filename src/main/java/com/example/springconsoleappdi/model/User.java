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
public class User extends BaseEntity implements StringsArray {

	public final static String[][] headers = {{"Id", "UserName", "Department", "Role", "Created", "Modified" },};

	@NotNull
	@Column(length = 100, columnDefinition = "varchar(50) default 'qqq'")
	String username;

	@OneToOne
	public Department department;

	//@Basic(optional = false)

	//@Enumerated
	Role role;


	public String[] toStringsArray() {
		return new String[] {
				String.valueOf(id), String.valueOf(username), String.valueOf(department.getDepName()),
				String.valueOf(role), String.valueOf(created), String.valueOf(modified)
		};
	}

//	public static String[] getHeaders() {
//		return new String[] {String.valueOf(id), String.valueOf(username), String.valueOf(department), String.valueOf(created), String.valueOf(modified)};
//	}

	@Override
	public String toString() {
		return "User{" +
				       "username='" + username + '\'' +
				       ", department=" + department +
				       ", role=" + role +
				       '}';
	}
}
