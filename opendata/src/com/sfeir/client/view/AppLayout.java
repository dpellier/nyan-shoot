package com.sfeir.client.view;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlowPanel;

public interface AppLayout {

	FlowPanel getMainPanel();
	AcceptsOneWidget getListPanel();
	AcceptsOneWidget getBreadcrumbPanel();
	
}
