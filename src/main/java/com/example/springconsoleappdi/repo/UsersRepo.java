package com.example.springconsoleappdi.repo;

import com.example.springconsoleappdi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UsersRepo extends //Repository<User, Long>
									CrudRepository<User, Long>
{

	List<User> findByUsername(String uname);

	//User findById(long id);
}


