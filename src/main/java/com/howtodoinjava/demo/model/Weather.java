package com.howtodoinjava.demo.model;

public class Weather {

	public Weather() {
		
	}

	private String ville_name;
	private String zip_code;
	private String pays;
	private String weather_message;

	public Weather(String ville_name, String zip_code, String pays, String weather_message) {
		this.ville_name = ville_name;
		this.zip_code = zip_code;
		this.pays = pays;
		this.weather_message=weather_message;
	}

	public String getVille_name() {
		return ville_name;
	}

	public String getZip_code() {
		return zip_code;
	}

	public String getPays() {
		return pays;
	}

	@Override
	public String toString() {
		return "Weather{" +
				"ville_name='" + ville_name + '\'' +
				", zip_code='" + zip_code + '\'' +
				", pays='" + pays + '\'' +
				'}';
	}
}
