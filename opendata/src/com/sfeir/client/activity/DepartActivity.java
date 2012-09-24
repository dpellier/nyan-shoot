package com.sfeir.client.activity;

import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.sfeir.client.ClientFactory;
import com.sfeir.client.place.DepartPlace;
import com.sfeir.client.view.DepartView;
import com.sfeir.shared.Depart;

public class DepartActivity extends AbstractActivity implements Presenter {
	
	private ClientFactory clientFactory;
	private String idRegion;


	public DepartActivity(DepartPlace place,ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		idRegion = place.getIdRegion();
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}
	

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		DepartView view = clientFactory.getDepartView();
		view.setPresenter(this);
		fetchAllDepart(view);
		containerWidget.setWidget(view.asWidget());
	}
	

	private void fetchAllDepart(final DepartView display) {
		clientFactory.getRpcService().getAllDepart(idRegion, new AsyncCallback<List<Depart>>() {

			@Override
			public void onSuccess(List<Depart> result) {
				display.setAllDepart(result, idRegion);
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO a finir
			}
		});
	}

}
