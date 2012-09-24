package com.sfeir.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.sfeir.client.activity.Presenter;

public class BreadcrumbViewImpl extends Composite implements BreadcrumbView {


	@UiTemplate("Breadcrumb.ui.xml")
	interface MyUiBinder extends UiBinder<HTMLPanel, BreadcrumbViewImpl> {
	};

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	private Presenter listener;
	
	@UiField
	UListElement liste;
	
	public BreadcrumbViewImpl() {
		initWidget(binder.createAndBindUi(this));
	}
	
	@Override
	public void setPresenter(Presenter presenter) {
		this.listener = presenter; 
	}
	
	public void addElement(String lien) {
		LIElement li = Document.get().createLIElement();
		li.setInnerText(lien);
		liste.appendChild(li);
	}
	
	@Override
	public void clear() {
		while (liste.hasChildNodes()) {
			liste.removeChild(liste.getLastChild());
		}
	}

	@Override
	public void addAnchor(String fragment, String text) {
		
		LIElement li = Document.get().createLIElement();
		
		AnchorElement ae = Document.get().createAnchorElement();
		ae.setInnerText(text);
		ae.setHref("#" + fragment);
		li.appendChild(ae);
		
		SpanElement sep = Document.get().createSpanElement();
		sep.setInnerText("/");
		sep.addClassName("divider");
		li.appendChild(sep);
		
		liste.appendChild(li);
	}
	
}
