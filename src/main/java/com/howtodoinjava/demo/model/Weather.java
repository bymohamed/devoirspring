package com.howtodoinjava.demo.model;

import io.swagger.annotations.ApiModelProperty;

public class Weather {

	public Weather() {
		
	}
	@ApiModelProperty(notes = "nom de la ville",name="ville_name",required=true,value="Nice")
	private String ville_name;
	@ApiModelProperty(notes = "code postale de la ville",name="zip_code",required=true,value="06000")
	private String zip_code;
	@ApiModelProperty(notes = "pays",name="pays",required=true,value="FR")
	private String pays;
	@ApiModelProperty(notes = "le message du Weather",name="weather_message",required=true,value="il fait beau")
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
