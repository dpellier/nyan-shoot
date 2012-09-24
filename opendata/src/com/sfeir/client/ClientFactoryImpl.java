package com.sfeir.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.sfeir.client.mvp.AppPlaceHistoryMapper;
import com.sfeir.client.view.BreadcrumbView;
import com.sfeir.client.view.BreadcrumbViewImpl;
import com.sfeir.client.view.DepartView;
import com.sfeir.client.view.DepartViewImpl;
import com.sfeir.client.view.RegionView;
import com.sfeir.client.view.RegionViewImpl;
import com.sfeir.client.view.VilleView;
import com.sfeir.client.view.VilleViewImpl;
import com.sfeir.shared.OpenDataRequestFactory;

public class ClientFactoryImpl implements ClientFactory {

	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(eventBus);
	private static final RegionView regionView = new RegionViewImpl();
	private static final DepartView departView = new DepartViewImpl();
	private static final VilleView villeView = new VilleViewImpl();
	private static final BreadcrumbView breadcrumbView = new BreadcrumbViewImpl();
	private static final ServiceOpenDataAsync rpcService = GWT.create(ServiceOpenData.class);
	private static final AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
	private static final OpenDataRequestFactory requestFactory = instanciateRequestFactory();
	private static OpenDataRequestFactory instanciateRequestFactory() {
		OpenDataRequestFactory create = GWT.create(OpenDataRequestFactory.class);
		create.initialize(eventBus);
		return create;
	}
	
	public AppPlaceHistoryMapper getHistoryMapper() {
		return historyMapper;
	}

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}
	

	@Override
	public RegionView getRegionView() {
		return regionView;
	}
	
	@Override
	public BreadcrumbView getBreadcrumbView() {
		return breadcrumbView;
	}

	@Override
	public DepartView getDepartView() {
		return departView;
	}

	@Override
	public ServiceOpenDataAsync getRpcService() {
		return rpcService;
	}
	
	@Override
	public VilleView getVilleView() {
		return villeView;
	}

	
}
