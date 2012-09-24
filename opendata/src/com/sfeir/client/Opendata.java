package com.sfeir.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.sfeir.client.mvp.BreadcrumbActivityMapper;
import com.sfeir.client.mvp.ListActivityMapper;
import com.sfeir.client.place.BasicPlace;
import com.sfeir.client.view.AppLayout;
import com.sfeir.client.view.AppLayoutImpl;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Opendata implements EntryPoint {

	private Place defaultPlace = new BasicPlace();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		ClientFactory clientFactory = GWT.create(ClientFactory.class);
		
		AppLayout appLayout = new AppLayoutImpl();
		
		// Start ActivityManager
		BreadcrumbActivityMapper breadcrumbActivityMapper = new BreadcrumbActivityMapper(clientFactory);
		ActivityManager breadcrumbActivityManager = new ActivityManager(breadcrumbActivityMapper, clientFactory.getEventBus());
		breadcrumbActivityManager.setDisplay(appLayout.getBreadcrumbPanel());

		// Start ActivityManager for the main widget with our ActivityMapper
		ActivityMapper listActivityMapper = new ListActivityMapper(clientFactory);
		ActivityManager listActivityManager = new ActivityManager(listActivityMapper, clientFactory.getEventBus());
		listActivityManager.setDisplay(appLayout.getListPanel());

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler( clientFactory.getHistoryMapper());
		historyHandler.register(clientFactory.getPlaceController(), clientFactory.getEventBus(), defaultPlace );
		
		// RequestFactory
		

		RootPanel.get().add(appLayout.getMainPanel());
		
		// Goes to place represented on URL or default place
		historyHandler.handleCurrentHistory();
	}
}
