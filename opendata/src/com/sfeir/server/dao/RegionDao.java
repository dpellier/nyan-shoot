package com.sfeir.server.dao;

import com.googlecode.objectify.ObjectifyService;
import com.sfeir.shared.Region;

public class RegionDao extends GenericDao<Region> {
	
	static {
		ObjectifyService.register(Region.class);
	}

	public RegionDao() {
		super(Region.class);
	}
}
