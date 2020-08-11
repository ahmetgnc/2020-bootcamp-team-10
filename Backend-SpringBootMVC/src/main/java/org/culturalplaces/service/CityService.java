package org.culturalplaces.service;

import java.util.List;

import org.culturalplaces.dao.jpa.entity.City;
import org.culturalplaces.dao.jpa.repository.CityRepository;
import org.culturalplaces.service.model.CityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;

	public City findByCityId(Long cityId) {

		return cityRepository.findWithCityId(cityId);
	}
	

	public List<City> getAllCityList() {

		return cityRepository.getAllCityList();
	}

	
	@Transactional
	public Long save(CityContext cityContext) {

		Long maxId = cityRepository.findMaxId() + 1;

		City city = new City();
		city.setCityId(maxId);
		city.setCityName(cityContext.getCityName());
		city.setCityDescription(cityContext.getCityDescription());
		city.setCityPhoto(cityContext.getCityPhoto());
		city.setCulturalPlace(cityContext.getCulturalPlace());
		city.setCityCoordinates(cityContext.getCityCoordinates());
		

		city = cityRepository.save(city);

		
		return city.getCityId();
	}

	
	public List<City> findByCityName(String cityName) {
		return cityRepository.findByCityName(cityName);
	}
	
	public List<City> findByCulturalPlaceName(String culturalPlace) {
		return cityRepository.findByCulturalPlaceName(culturalPlace);
	}

	@Transactional
	public void delete(Long cityId) {
		if(cityRepository.findWithCityId(cityId)!= null) {
			cityRepository.deleteById(cityId);
		}
	}

}