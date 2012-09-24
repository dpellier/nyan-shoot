package com.sfeir.server;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sfeir.client.ServiceOpenData;
import com.sfeir.server.dao.DepartDao;
import com.sfeir.server.dao.RegionDao;
import com.sfeir.server.dao.VilleDao;
import com.sfeir.shared.Depart;
import com.sfeir.shared.Region;
import com.sfeir.shared.Ville;

/**
* The server side implementation of the RPC service.
*/
@SuppressWarnings("serial")
public class ServiceOpenDataImpl extends RemoteServiceServlet implements ServiceOpenData {
	
	private final RegionDao regionDao = new RegionDao();
	private final VilleDao villeDao = new VilleDao();
	
	public List<Region> getAllRegion() {
		List<Region> res = new ArrayList<Region>();
		try {
			for (Region reg : regionDao.getAll("name")) {
				res.add(reg);
			}
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public List<Depart> getAllDepart(String idRegion) throws IllegalArgumentException {
		try {
			return new DepartDao().getAllById("name", "regionId", idRegion);
		} catch (EntityNotFoundException e) {
			throw new RuntimeException("impossible de recuperer la liste des departements pour la region:" + idRegion, e);
		} 
	}
	
	@Override
	public List<Ville> getAllVille(String idDepart) throws IllegalArgumentException {
		try {
			return new VilleDao().getAllById("name", "departId", idDepart);
		} catch (EntityNotFoundException e) {
			throw new RuntimeException("impossible de recuperer la liste des villes pour le departement:" + idDepart, e);
		} 
	}
	
}
