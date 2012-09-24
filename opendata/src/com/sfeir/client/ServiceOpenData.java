package com.sfeir.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sfeir.shared.Depart;
import com.sfeir.shared.Region;
import com.sfeir.shared.Ville;

@RemoteServiceRelativePath("service")
public interface ServiceOpenData extends RemoteService {
	List<Region> getAllRegion() throws IllegalArgumentException;
	List<Depart> getAllDepart(String idRegion) throws IllegalArgumentException;
	List<Ville> getAllVille(String idDepart) throws IllegalArgumentException;
}
