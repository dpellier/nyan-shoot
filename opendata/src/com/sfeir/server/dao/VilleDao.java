package com.sfeir.server.dao;

import com.googlecode.objectify.ObjectifyService;
import com.sfeir.shared.Ville;

public class VilleDao extends GenericDao<Ville> {

	static {
		ObjectifyService.register(Ville.class);
	}

	public VilleDao() {
		super(Ville.class);
	}
		
}
