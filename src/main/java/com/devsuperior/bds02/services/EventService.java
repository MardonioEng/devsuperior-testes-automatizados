package com.devsuperior.bds02.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.EventRepository;
import com.devsuperior.bds02.services.exceptions.EventNotFoundException;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Transactional
	public EventDTO update(Long id, EventDTO eventDTO) {
		try {
			Event entity = eventRepository.getOne(id);
			entity.setName(eventDTO.getName());
			entity.setDate(eventDTO.getDate());
			entity.setUrl(eventDTO.getUrl());
			entity.setCity(new City(eventDTO.getCityId(), null));
			entity = eventRepository.save(entity);
			
			return new EventDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new EventNotFoundException("Event not found.");
		}
	}
	
}
