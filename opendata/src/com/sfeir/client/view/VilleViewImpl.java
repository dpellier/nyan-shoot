package com.sfeir.client.view;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.sfeir.client.activity.Presenter;
import com.sfeir.shared.Ville;

public class VilleViewImpl extends Composite implements VilleView {

	@UiTemplate("Ville.ui.xml")
	interface MyUiBinder extends UiBinder<Panel, VilleViewImpl> {
	};
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	@UiField
	CellTable<String> villes = defineTable();
	@UiField(provided=true)
	SimplePager pager;
	private Presenter listener;
	private List<Ville> listVilles = new ArrayList<Ville>();

	public VilleViewImpl() {
		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
		pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
		pager.setDisplay(villes);
		initWidget(binder.createAndBindUi(this));
	}
	
	

	/**
	 * Instancie et configure la table
	 * @return
	 */
	private CellTable<String> defineTable() {
		TextColumn<String> nameColumn = new TextColumn<String>() {
			@Override
			public String getValue(String object) {
				return object;
			}
		};
		CellTable<String> table = new CellTable<String>(10);
		table.addColumn(nameColumn);
		return table;
	}

	@Override
	public void setAllVille(List<Ville> villeList) {
		listVilles = villeList;
		for (int index = 0; index < villeList.size(); index++) {
			Label label = new Label(villeList.get(index).getName());
			label.setStyleName("pointer");
//			villes.setWidget(index, 1, label);
			// TODO refaire
		}

	}

	@Override
	public int getClickedRow(ClickEvent event) {
//		Cell row = villes.getCellForEvent(event);
//		return row.getRowIndex();
		// TODO refaire
		return 0;
	}

	public void setPresenter(Presenter presenter) {
		this.listener = presenter;
	}
	
	public void clearRows() {
//		villes.removeAllRows();
		// TODO refaire
	}

}
