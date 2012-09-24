package com.sfeir.client.view;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.IsWidget;
import com.sfeir.client.activity.Presenter;
import com.sfeir.shared.Depart;

public interface DepartView extends IsWidget {

	void setAllDepart(List<Depart> depart, String idRegion);
	void setPresenter(Presenter presenter);
	int getClickedRow(ClickEvent event);

}