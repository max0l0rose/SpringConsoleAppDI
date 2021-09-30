package com.example.springconsoleappdi.repo;

import com.example.springconsoleappdi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

//public interface UserRepository extends PagingAndSortingRepository<User, Long> {
//	Optional<User> findByUsername(String name);
//}


public interface UserRepository extends //Repository<User, Long>
		                                   CrudRepository<User, Long>
{
	List<User> findByUsername(String name);
	//User findById(long id);
}


