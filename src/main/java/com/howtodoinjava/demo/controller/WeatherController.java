package com.howtodoinjava.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.demo.model.Weather;

@Api(value = "WeatherController", description = "REST Apis related to weather Entity!!!!")
@RestController
public class WeatherController {

	static List<Weather> weatherList = new ArrayList<Weather>();

	static{
	weatherList.add(new Weather("Nice","06000","FR","il fait beau"));
	weatherList.add(new Weather("Marseille","13000","FR","il fait chaud"));
	weatherList.add(new Weather("Milan","20019","IT","il fait froid"));
	weatherList.add(new Weather("Rome","00100","IT","il pleut"));

	}
	@ApiOperation(value = "Get list of weather by country ", response = Iterable.class, tags = "getWeathersByCountry")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@RequestMapping("/weather/{pays}")
    public List<Weather> getWeathersByCountry(@PathVariable(value = "pays") String pays)
    {
		return weatherList.stream()
				.filter(p -> p.getPays().equals(pays)).collect(Collectors.toList());
    }

	@ApiOperation(value = "Get weather by zip or name ", response = Iterable.class, tags = "getWeathersByNameOrZip")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
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
