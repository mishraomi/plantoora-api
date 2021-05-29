package com.firebolt.plantoora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firebolt.plantoora.entity.Plant;
import com.firebolt.plantoora.repository.PlantRepository;

@Service
public class PlantService {
	
	@Autowired
	private PlantRepository plantRepository;

	public List<Plant> fetchAllPlants() {
		return plantRepository.findAll();
	}

	public Optional<Plant> fetchPlantById(Integer plantId) {
		return plantRepository.findById(plantId);
	}

	public Plant saveUpdatePlant(Plant plant) {
		return plantRepository.saveAndFlush(plant);
	}

	public void deletePlant(Plant plant) {
		plantRepository.delete(plant);
	}

	
}
