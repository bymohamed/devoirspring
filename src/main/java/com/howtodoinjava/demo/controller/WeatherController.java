package com.howtodoinjava.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.demo.model.Weather;

@RestController
public class WeatherController {

	static List<Weather> weatherList = new ArrayList<Weather>();

	static{
	weatherList.add(new Weather("Nice","06000","FR","il fait beau"));
	weatherList.add(new Weather("Marseille","13000","FR","il fait chaud"));
	weatherList.add(new Weather("Milan","20019","IT","il fait froid"));
	weatherList.add(new Weather("Rome","00100","IT","il pleut"));

	}
	@RequestMapping("/weather/{pays}")
    public List<Weather> getWeathersByCountry(@PathVariable(value = "pays") String pays)
    {
		return weatherList.stream()
				.filter(p -> p.getPays().equals(pays)).collect(Collectors.toList());
    }

	@RequestMapping("/weatherSearch/{name}")
	public Weather getWeathersByNameOrZip(@PathVariable(value = "name") String name)
	{
		return weatherList.stream()
				.filter(p -> p.getVille_name().equals(name) || p.getZip_code().equals(name)).collect(Collectors.toList()).get(0);
	}

	@RequestMapping("/")
	public List<Weather> getAllWeathers()
	{

		return this.weatherList;
	}

}
