package com.example.springconsoleappdi.repo;

import com.example.springconsoleappdi.model.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepsRepo extends CrudRepository<Department, Long> {

	List<Department> findByDepName(String uname);

	//Department findById(long id);
}