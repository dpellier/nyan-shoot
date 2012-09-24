package com.sfeir.client.view;

import com.google.gwt.user.client.ui.IsWidget;
import com.sfeir.client.activity.Presenter;

public interface BreadcrumbView extends IsWidget {
	
	void setPresenter(Presenter presenter);
	void addElement(String lien);
	void clear();
	void addAnchor(String fragment, String string);

}
