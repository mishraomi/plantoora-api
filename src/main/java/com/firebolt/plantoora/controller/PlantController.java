package com.firebolt.plantoora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firebolt.plantoora.entity.Plant;
import com.firebolt.plantoora.service.PlantService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/plant")
public class PlantController {
	
	@Autowired
	private PlantService plantService;
	
	@GetMapping("/")
	public ResponseEntity<List<Plant>> getAllPlants(){
		return ResponseEntity.ok(plantService.fetchAllPlants());
	}
	
	@GetMapping("/{plantId}")
	public ResponseEntity<Plant> getPlantById(@PathVariable Integer plantId) throws Exception{
		Plant plant = plantService.fetchPlantById(plantId).orElseThrow(() -> new Exception("Plant " + plantId + " not found!"));
		return ResponseEntity.ok().body(plant);
	}
	
	@PostMapping("/")
	public ResponseEntity<Plant> saveUpdatePlant(@RequestBody Plant plant){
		return ResponseEntity.ok().body(plantService.saveUpdatePlant(plant));
	} 
	
	@DeleteMapping("/")
	public ResponseEntity<String> deletePlant(@RequestBody Plant plant){
		plantService.deletePlant(plant);
		return ResponseEntity.ok().body("Plant " + plant.getPlantId() + " deleted!");
	}
}
