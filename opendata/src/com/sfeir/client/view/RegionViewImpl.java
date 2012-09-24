package com.sfeir.client.view;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.sfeir.client.activity.Presenter;
import com.sfeir.client.place.DepartPlace;
import com.sfeir.shared.Region;

public class RegionViewImpl extends Composite implements
		RegionView {

	@UiTemplate("Region.ui.xml")
	interface MyUiBinder extends UiBinder<Panel, RegionViewImpl> {
	};

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	@UiField
	FlexTable regions = new FlexTable();
	private Presenter listener;
	private List<Region> regionList;
	

	public RegionViewImpl() {
		initWidget(binder.createAndBindUi(this));
	}

	@Override
	public void setAllRegion(List<Region> regionList) {
		this.regionList = regionList;
		regions.removeAllRows();
		for (int index = 0; index < regionList.size(); index++) {
			Label label = new Label(regionList.get(index).getName());
			label.setStyleName("pointer");
			regions.setWidget(index, 1, label);
		}
	}

	@UiHandler("regions")
	void onClickRegion(ClickEvent e)
	{
		Region region = regionList.get(getClickedRow(e));
		listener.goTo(new DepartPlace(region.getId()));
	}
	
	public int getClickedRow(ClickEvent event) {
		Cell row = regions.getCellForEvent(event);
		return row.getRowIndex();
	}

	public void setPresenter(Presenter presenter) {
		this.listener = presenter;
	}
}
