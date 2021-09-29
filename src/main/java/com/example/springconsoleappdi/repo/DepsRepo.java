package com.example.springconsoleappdi.repo;

import com.example.springconsoleappdi.model.Department;
import com.example.springconsoleappdi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface DepsRepo extends PagingAndSortingRepository<Department, Integer> {
	List<Department> findByDepName(String uname);
	//Department findById(long id);
}