package com.sfeir.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.Prefix;

public class DepartPlace extends Place {
	
	public static final String PREFIX = "!DepartPlace";

	private String idRegion; 
	
	public DepartPlace(String idRegion) {
		this.idRegion = idRegion;
	}
	
	public boolean validate() {
		if (this.idRegion != null && !this.idRegion.equals("")) {
			return true;
		}
		return false;
	}
	
	
	@Prefix(PREFIX)
	public static class Tokenizer implements com.google.gwt.place.shared.PlaceTokenizer<DepartPlace>
	{


		@Override
		public String getToken(DepartPlace place)
		{
			return place.getIdRegion();
		}

		@Override
		public DepartPlace getPlace(String token)
		{
			return new DepartPlace(token);
		}
		
	}

	public String getIdRegion() {
		return idRegion;
	}
}
