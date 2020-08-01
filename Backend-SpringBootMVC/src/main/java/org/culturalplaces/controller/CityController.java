package org.culturalplaces.controller;

import java.util.List;

import org.culturalplaces.dao.jpa.entity.City;
import org.culturalplaces.service.CityService;
import org.culturalplaces.service.model.CityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
public class CityController {

	@Autowired
	private CityService cityService;
	
	
	@RequestMapping(value = "/city/{id}", method = RequestMethod.GET)
	public City findByCityId(@PathVariable("id") Long id) {
		
		return cityService.findByCityId(id);
	}
	
	@RequestMapping(value = "/city/list", method = RequestMethod.GET)
	public List<City> getAllCityList() {
		
		return cityService.getAllCityList();
	}
	
	@RequestMapping(value = "/city", method = RequestMethod.POST)
	public Long save(@RequestBody CityContext cityContext) {
		
		return cityService.save(cityContext);
	}
	
	
}