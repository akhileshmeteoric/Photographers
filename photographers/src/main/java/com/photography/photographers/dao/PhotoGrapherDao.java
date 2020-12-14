package com.photography.photographers.dao;

import org.springframework.data.repository.CrudRepository;

import com.photography.photographers.model.PhotoGrapher;

public interface PhotoGrapherDao  extends CrudRepository<PhotoGrapher, Long> {

	
}
