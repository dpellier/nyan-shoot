package com.sfeir.shared;

import java.io.Serializable;

import javax.persistence.Id;

public class Ville implements Serializable {

	@Id
	private String id;
	private String name;
	private String departId;

	public Ville() {}
	
	public Ville(String id, String name, String departId) {
		this.id = id;
		this.name = name;
		this.departId = departId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDepartId() {
		return departId;
	}
	public void setDepartId(String departId) {
		this.departId = departId;
	}
}
