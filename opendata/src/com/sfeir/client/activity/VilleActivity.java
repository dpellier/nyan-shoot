package com.sfeir.client.activity;

import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.sfeir.client.ClientFactory;
import com.sfeir.client.place.VillePlace;
import com.sfeir.client.view.VilleView;
import com.sfeir.shared.Ville;

public class VilleActivity extends AbstractActivity implements Presenter {
	
	private ClientFactory clientFactory;
	private String idDepart;
	private String idRegion;


	public VilleActivity(VillePlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		idDepart = place.getIdDepart();
		idRegion = place.getIdRegion();
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}
	

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		VilleView view = clientFactory.getVilleView();
		view.setPresenter(this);
		fetchAllVille(view);
		containerWidget.setWidget(view.asWidget());
	}
	

	private void fetchAllVille(final VilleView display) {
		display.clearRows();
		clientFactory.getRpcService().getAllVille(idDepart, new AsyncCallback<List<Ville>>() {

			@Override
			public void onSuccess(List<Ville> result) {
				display.setAllVille(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO a finir
			}
		});
	}
}
