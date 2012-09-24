package com.sfeir.shared;

import java.io.Serializable;

import javax.persistence.Id;

@SuppressWarnings("serial")
public class Region implements Serializable {
	
	@Id
	private String id;
	private String name;
	
	public Region() {
	}

	
	public Region(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param nom the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
