package com.devsuperior.bds02.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.services.exceptions.CityNotFoundException;
import com.devsuperior.bds02.services.exceptions.DatabaseIntegrityException;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Transactional(readOnly = true)
	public List<CityDTO> findAll() {
		List<City> list = cityRepository.findAll(Sort.by("name"));
		return list.stream().map(city -> new CityDTO(city)).collect(Collectors.toList());
	}
	
	@Transactional
	public CityDTO insert(CityDTO cityDTO) {
		City entity = new City();
		entity.setName(cityDTO.getName());
		entity  = cityRepository.save(entity);
		return new CityDTO(entity);
	}
	
	public void delete(Long id) {
		try {
			cityRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new CityNotFoundException("City not found");
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseIntegrityException("Id dependente!");
		}
	}

}
