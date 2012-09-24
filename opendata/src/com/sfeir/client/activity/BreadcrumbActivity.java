package com.sfeir.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.sfeir.client.ClientFactory;
import com.sfeir.client.place.BasicPlace;
import com.sfeir.client.place.DepartPlace;
import com.sfeir.client.place.VillePlace;
import com.sfeir.client.view.BreadcrumbView;

public class BreadcrumbActivity extends AbstractActivity implements Presenter {

	private ClientFactory clientFactory;

	public BreadcrumbActivity(Place place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		BreadcrumbView view = clientFactory.getBreadcrumbView();
		view.clear();
		if ((place instanceof DepartPlace) && (((DepartPlace)place).validate())) {
			String fragment = clientFactory.getHistoryMapper().getToken(new BasicPlace());
			view.addAnchor(fragment, "Régions");
			view.addElement("Départements");
		}
		else if (place instanceof VillePlace) {
			String fragment = clientFactory.getHistoryMapper().getToken(new BasicPlace());
			view.addAnchor(fragment, "Régions");
			fragment = clientFactory.getHistoryMapper().getToken(new DepartPlace(((VillePlace)place).getIdRegion()));
			view.addAnchor(fragment, "Départements");
			view.addElement("Villes");
		} else {
			view.addElement("Régions");
		}
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		BreadcrumbView view = clientFactory.getBreadcrumbView();
		view.setPresenter(this);
		panel.setWidget(view.asWidget());
	}

	@Override
	public void goTo(Place place) {
		// TODO Auto-generated method stub
		System.out.println("");
	}

}
