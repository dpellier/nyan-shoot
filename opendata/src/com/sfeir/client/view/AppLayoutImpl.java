package com.sfeir.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class AppLayoutImpl implements AppLayout {


	@UiTemplate("AppLayout.ui.xml")
	interface MyUiBinder extends UiBinder<FlowPanel, AppLayoutImpl> {
	};

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	
	private final FlowPanel mainPanel;
	
	@UiField
	SimplePanel breadcrumbPanel;
	@UiField
	SimplePanel listPanel;

	public AppLayoutImpl() {
		mainPanel = binder.createAndBindUi(this);
	}
	
	public FlowPanel getMainPanel() {
		return mainPanel;
	}

	public AcceptsOneWidget getBreadcrumbPanel() {
		return new AcceptsOneWidget() {
			
			@Override
			public void setWidget(IsWidget w) {
				Widget widget = Widget.asWidgetOrNull(w);
				breadcrumbPanel.setWidget(widget);
			}
		};
	}
	
	public AcceptsOneWidget getListPanel() {
		return new AcceptsOneWidget() {
			
			@Override
			public void setWidget(IsWidget w) {
				Widget widget = Widget.asWidgetOrNull(w);
				listPanel.setWidget(widget);
			}
		};
	}
}
