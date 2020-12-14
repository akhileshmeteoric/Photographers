package com.photography.photographers.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.photography.photographers.model.Category;

@Repository
public interface CategoryDao extends CrudRepository<Category, Long> {

	@Query("from Category c where c.offering_id=?1")
	public Category getCategoryByOfferingId(long id);
	
	@Query("from Category c where c.name=?1")
	public List<Category> getCategoryByName(String categoryName);
}
