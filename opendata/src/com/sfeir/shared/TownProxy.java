package com.sfeir.shared;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(com.sfeir.server.domain.Town.class)
public interface TownProxy extends EntityProxy {
	
	EntityProxyId<TownProxy> stableId();
	String getId();
	String getName();
	String getDepartId();

}
