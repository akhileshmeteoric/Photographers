package com.photography.photographers.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Subcategory {

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
	private long offering_id;

	public long getOfferings_id() {
		return offering_id;
	}

	public void setOfferings_id(long offerings_id) {
		this.offering_id = offerings_id;
	}

	public Subcategory() {
		super();
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

}
