package com.photography.photographers.model;

import java.util.Date;
import java.util.List;

public class Offerings {

	long id;
	String name;

	Date createdate;

	Date updatedate;

	Category category;

	private List<Subcategory> subcategory;

	public Offerings() {
		super();
	}
	
	

	public void setId(long id) {
		this.id = id;
	}



	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void offerings(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public List<Subcategory> getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(List<Subcategory> subcategory) {
		this.subcategory = subcategory;
	}

}
