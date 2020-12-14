package com.photography.photographers.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.photography.photographers.model.Subcategory;

@Repository
public interface SubCategoryDao extends JpaRepository<Subcategory, Long> {

	@Query("from Subcategory c where c.offering_id=?1")
	public List<Subcategory> getSubCategoryByOfferingId(long id);

	@Query("from Subcategory c where c.name=?1")
	public List<Subcategory> getSubCategoryByName(String name);
}
