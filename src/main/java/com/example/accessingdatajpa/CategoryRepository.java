package com.example.accessingdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
//	public interface CategoryRepository extends CrudRepository<Customer, Long> {

	List<Category> findByName(String name);

	Category findById(long id);
}
