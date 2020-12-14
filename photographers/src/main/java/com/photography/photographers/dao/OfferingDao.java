package com.photography.photographers.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.photography.photographers.model.Category;
import com.photography.photographers.model.Offering;

public interface OfferingDao  extends JpaRepository<Offering, Long>{

	@Query("from Offering c where c.id=?1")
	public Offering getOfferingById(long id);
}
