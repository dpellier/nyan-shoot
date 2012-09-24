package com.sfeir.shared;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.sfeir.server.domain.Town;

@Service(com.sfeir.server.domain.Town.class)
public interface TownRequest extends RequestContext {

	Request<List<Town>> findAllVilles();
	Request<List<Town>> findVilles(int firstResult, int maxResult);
}
