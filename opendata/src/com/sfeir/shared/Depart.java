package com.sfeir.shared;

import java.io.Serializable;

import javax.persistence.Id;

@SuppressWarnings("serial")
public class Depart implements Serializable {

	@Id
	private String id;
	private String regionId;
	private String name;
	
	public Depart() {}
	
	public Depart( String id, String name, String regionid) {
		this.id = id;
		this.name = name;
		this.regionId = regionid;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	
}
