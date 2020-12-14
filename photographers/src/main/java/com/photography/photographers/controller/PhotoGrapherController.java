package com.photography.photographers.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.photography.photographers.model.Offering;
import com.photography.photographers.model.Offerings;
import com.photography.photographers.model.PhotoGrapher;
import com.photography.photographers.service.PhotoGrapherService;

@RestController

public class PhotoGrapherController {

	@Autowired
	PhotoGrapherService photoGrapherService;

	@GetMapping(path = "/test")
	public String test() {

		return "hello";
	}

	@PostMapping(path = "/photograpgher/profile", consumes = "application/json", produces = "application/json")
	public PhotoGrapher createProfile(@RequestBody PhotoGrapher photoGrapher) {

		photoGrapher = photoGrapherService.saveProfile(photoGrapher);
		return photoGrapher;
	}

	@PostMapping(path = "/photographer/addofferings", consumes = "application/json", produces = "application/json")
	public Offering createOfferings(@RequestBody Offerings offerings) {

		Offering offering = photoGrapherService.createOfferings(offerings);
		return offering;
	}

	@GetMapping(path = "/photograpgher/getofferings", produces = "application/json")
	public List<Offerings> getAllOfferings() {

		return photoGrapherService.getAllOfferings();
	}

	@GetMapping(path = "/photograpgher/getofferingsbycategory", produces = "application/json")
	public List<Offerings> getAllOfferingsByCategoty(@QueryParam("category") String category,
			@QueryParam("subcategory") String subcategory) {
		List<Offerings> offeringsList = new ArrayList<>();
		if (Objects.nonNull(category) && !category.isEmpty()) {
			offeringsList = photoGrapherService.getAllOfferingsByCategory(category);
		} else if (Objects.nonNull(subcategory) && !subcategory.isEmpty()) {
			offeringsList = photoGrapherService.getAllOfferingsBySubCategory(subcategory);
		}

		return offeringsList;
	}

	@GetMapping(path = "/photograpgher/getofferingsbyid", produces = "application/json")
	public List<Offerings> getAllOfferingsById(@QueryParam("offeringids") String offeringids) {
		List<Offerings> offeringsList = new ArrayList<>();
		Offerings offering = photoGrapherService.getOfferingsById(Long.parseLong(offeringids));
		offeringsList.add(offering);
		return offeringsList;
	}

}
