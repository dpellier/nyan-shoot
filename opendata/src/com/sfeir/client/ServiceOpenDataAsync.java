package com.sfeir.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sfeir.shared.Depart;
import com.sfeir.shared.Region;
import com.sfeir.shared.Ville;

/**
* The async counterpart of <code>ServiceOpenData</code>.
*/
public interface ServiceOpenDataAsync {
	void getAllRegion(AsyncCallback<List<Region>> callback) throws IllegalArgumentException;
	void getAllDepart(String idRegion, AsyncCallback<List<Depart>> callback) throws IllegalArgumentException;
	void getAllVille(String idDepart, AsyncCallback<List<Ville>> callback) throws IllegalArgumentException;
}
