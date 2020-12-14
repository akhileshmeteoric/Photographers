package com.photography.photographers.service;

import java.util.List;

import com.photography.photographers.model.Offering;
import com.photography.photographers.model.Offerings;
import com.photography.photographers.model.PhotoGrapher;

public interface PhotoGrapherService {
	
	public PhotoGrapher saveProfile(PhotoGrapher grapher);

	public Offering createOfferings(Offerings offerings);	
	public List<Offerings> getAllOfferings();
	public List<Offerings> getAllOfferingsByCategory(String name);
	public List<Offerings> getAllOfferingsBySubCategory(String name);
	public Offerings getOfferingsById(long id);
	
	
}
