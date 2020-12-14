package com.photography.photographers.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.photography.photographers.dao.CategoryDao;
import com.photography.photographers.dao.OfferingDao;
import com.photography.photographers.dao.PhotoGrapherDao;
import com.photography.photographers.dao.SubCategoryDao;
import com.photography.photographers.model.Category;
import com.photography.photographers.model.Offering;
import com.photography.photographers.model.Offerings;
import com.photography.photographers.model.PhotoGrapher;
import com.photography.photographers.model.Subcategory;
import com.photography.photographers.service.PhotoGrapherService;

@Service
public class PhotoGrapherServiceImpl implements PhotoGrapherService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	PhotoGrapherDao photoGrapherDao;

	@Autowired
	OfferingDao offeringDao;

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	SubCategoryDao subCategoryDao;

	@Transactional
	@Override
	public Offering createOfferings(Offerings offerings) {

		Offering offering = new Offering();
		offering.setName(offerings.getName());
		offering.setCreatedate(new Date());
		offering.setUpdatedate(new Date());
		Offering savedOffering = offeringDao.save(offering);

		Long offering_id = savedOffering.getId();

		Category category = new Category();
		category.setOffering_id(offering_id);
		category.setCreatedate(new Date());
		category.setUpdatedate(new Date());
		category.setName(offerings.getCategory().getName());
		category.setImages(offerings.getCategory().getImages());
		category.setVedios(offerings.getCategory().getVedios());
		categoryDao.save(category);

		Set<Subcategory> subcategoryList = new HashSet(offerings.getSubcategory());
		subcategoryList.forEach(subcategory ->

		{
			subcategory.setCreatedate(new Date());
			subcategory.setUpdatedate(new Date());
			subcategory.setOfferings_id(offering_id);

		});

		subCategoryDao.saveAll(subcategoryList);

		return savedOffering;
	}

	@Override
	public List<Offerings> getAllOfferings() {
		List<Offerings> offeringsList = new ArrayList<>();

		List<Offering> offeringList = offeringDao.findAll();

		long offering_id = 0;
		for (Offering offering : offeringList) {
			Offerings offerings = new Offerings();
			offering_id = offering.getId();
			offerings.setId(offering_id);
			offerings.setName(offering.getName());
			offerings.setCreatedate(offering.getCreatedate());
			offerings.setUpdatedate(offering.getUpdatedate());

			Category category = new Category();
			category = categoryDao.getCategoryByOfferingId(offering_id);
			offerings.setCategory(category);

			List<Subcategory> subCategoryList = new ArrayList<Subcategory>();
			subCategoryList = subCategoryDao.getSubCategoryByOfferingId(offering_id);
			offerings.setSubcategory(subCategoryList);

			offeringsList.add(offerings);
		}
		return offeringsList;
	}

	@Override
	public List<Offerings> getAllOfferingsByCategory(String name) {

		List<Offerings> offeringsList = new ArrayList<>();

		List<Category> categorylist = categoryDao.getCategoryByName(name);

		for (Category category : categorylist) {
			Offerings offerings = new Offerings();

			Offering offering = offeringDao.getOfferingById(category.getOffering_id());
			offerings.setId(offering.getId());
			offerings.setName(offering.getName());
			offerings.setCreatedate(offering.getCreatedate());
			offerings.setUpdatedate(offering.getUpdatedate());

			offerings.setCategory(category);

			List<Subcategory> list = subCategoryDao.getSubCategoryByOfferingId(category.getOffering_id());
			offerings.setSubcategory(list);

			offeringsList.add(offerings);
		}

		return offeringsList;
	}

	@Override
	public List<Offerings> getAllOfferingsBySubCategory(String name) {
		List<Offerings> offeringsList = new ArrayList<>();

		List<Subcategory> subCategorylist = subCategoryDao.getSubCategoryByName(name);

		long offering_id = subCategorylist.get(0).getOfferings_id();
		Offerings offerings = new Offerings();

		Offering offering = offeringDao.getOfferingById(offering_id);
		offerings.setId(offering.getId());
		offerings.setName(offering.getName());
		offerings.setCreatedate(offering.getCreatedate());
		offerings.setUpdatedate(offering.getUpdatedate());

		offerings.setCategory(categoryDao.getCategoryByOfferingId(offering_id));

		offerings.setSubcategory(subCategorylist);

		offeringsList.add(offerings);

		return offeringsList;
	}

	@Override
	public Offerings getOfferingsById(long id) {
		Offerings offerings = new Offerings();
		Offering offering = offeringDao.getOfferingById(id);
		offerings.setId(offering.getId());
		offerings.setName(offering.getName());
		offerings.setCreatedate(offering.getCreatedate());
		offerings.setUpdatedate(offering.getUpdatedate());

		offerings.setCategory(categoryDao.getCategoryByOfferingId(id));

		List<Subcategory> list = subCategoryDao.getSubCategoryByOfferingId(id);
		offerings.setSubcategory(list);
		return offerings;
	}

	@Override
	public PhotoGrapher saveProfile(PhotoGrapher grapher) {
		PhotoGrapher photoGrapher = photoGrapherDao.save(grapher);
		return photoGrapher;
	}

}
