package com.sfeir.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.sfeir.client.ClientFactory;
import com.sfeir.client.activity.DepartActivity;
import com.sfeir.client.activity.RegionActivity;
import com.sfeir.client.activity.VilleActivity;
import com.sfeir.client.place.DepartPlace;
import com.sfeir.client.place.VillePlace;

public class ListActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	public ListActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override
	public Activity getActivity(Place place) {
		if ((place instanceof DepartPlace) && (((DepartPlace)place).validate())) {	
			return new DepartActivity((DepartPlace) place, clientFactory);
		}
		else if (place instanceof VillePlace) {
			return new VilleActivity((VillePlace) place, clientFactory);
		} else {
			return new RegionActivity(clientFactory);
		}
	}
}
