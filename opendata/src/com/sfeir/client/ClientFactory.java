package com.sfeir.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.sfeir.client.mvp.AppPlaceHistoryMapper;
import com.sfeir.client.view.BreadcrumbView;
import com.sfeir.client.view.DepartView;
import com.sfeir.client.view.RegionView;
import com.sfeir.client.view.VilleView;

public interface ClientFactory {
	EventBus getEventBus();
	PlaceController getPlaceController();
	ServiceOpenDataAsync getRpcService();
	AppPlaceHistoryMapper getHistoryMapper();
	RegionView getRegionView();
	DepartView getDepartView();
	VilleView getVilleView();
	BreadcrumbView getBreadcrumbView();
}
