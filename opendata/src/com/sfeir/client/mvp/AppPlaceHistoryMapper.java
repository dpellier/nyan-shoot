package com.sfeir.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.sfeir.client.place.BasicPlace;
import com.sfeir.client.place.DepartPlace;
import com.sfeir.client.place.VillePlace;

@WithTokenizers( { BasicPlace.Tokenizer.class, DepartPlace.Tokenizer.class, VillePlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
