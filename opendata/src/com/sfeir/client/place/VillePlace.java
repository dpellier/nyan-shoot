package com.sfeir.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.Prefix;

public class VillePlace extends Place {
	
	public static final String PREFIX = "!VillePlace";

	private String idDepart;
	private String idRegion;
	
	public VillePlace(String idDepart, String idRegion) {
		this.idDepart = idDepart;
		this.idRegion = idRegion;
	}
	
	@Prefix(PREFIX)
	public static class Tokenizer implements com.google.gwt.place.shared.PlaceTokenizer<VillePlace>
	{


		@Override
		public String getToken(VillePlace place)
		{
			return place.getIdDepart() + "|" + place.getIdRegion();
		}

		@Override
		public VillePlace getPlace(String token)
		{
			String[] parse = token.split("\\|");
			return new VillePlace(parse[0], parse[1]);
		}
		
	}

	public String getIdDepart() {
		return idDepart;
	}

	public String getIdRegion() {
		return idRegion;
	}
}
