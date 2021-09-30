package com.example.springconsoleappdi.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MyPagedService<T> {
	public Page<T> getPage(Pageable page);
	Optional<T> show(int id);
	T save(T o);
	void delete(int id);
}
