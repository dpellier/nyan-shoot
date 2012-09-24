package com.sfeir.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.sfeir.client.ClientFactory;
import com.sfeir.client.activity.BreadcrumbActivity;

public class BreadcrumbActivityMapper implements ActivityMapper {

	
	private ClientFactory clientFactory;
	
	public BreadcrumbActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		return new BreadcrumbActivity(place, clientFactory);
	}

}
