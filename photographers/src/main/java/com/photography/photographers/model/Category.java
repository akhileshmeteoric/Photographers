package com.photography.photographers.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	long id;
	@Column
	String name;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	Date createdate;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	Date updatedate;

	@Column
	long offering_id;

	@ElementCollection
	@CollectionTable(name = "category_images", joinColumns = @JoinColumn(name = "category_id"))
	@Column(name = "images")
	List<String> images = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "category_vedios", joinColumns = @JoinColumn(name = "category_id"))
	@Column(name = "vedios")
	List<String> vedios = new ArrayList<>();

	public Category() {
		super();
	}

	public long getOffering_id() {
		return offering_id;
	}

	public void setOffering_id(long offering_id) {
		this.offering_id = offering_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public List<String> getVedios() {
		return vedios;
	}

	public void setVedios(List<String> vedios) {
		this.vedios = vedios;
	}

}
