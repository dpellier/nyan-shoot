package com.sfeir.shared;

import com.google.web.bindery.requestfactory.shared.RequestFactory;


/**
 * Request factory de l'application. 
 * @author sfeir
 *
 */
public interface OpenDataRequestFactory extends RequestFactory {

	/** Return a request selector */
	TownRequest townRequest();
}
