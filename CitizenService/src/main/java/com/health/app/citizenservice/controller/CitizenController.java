package com.health.app.citizenservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health.app.citizenservice.entity.Citizen;
import com.health.app.citizenservice.services.CitizenService;

@RestController
@RequestMapping("citizen")
public class CitizenController {

	@Autowired
	private CitizenService citizenService;
	
	@GetMapping(path="/test")
	public ResponseEntity<String> test(){
		return new ResponseEntity<>("Hello", HttpStatus.OK);
	}
	
	@GetMapping(path="/vaccination-center-id/{id}")
	public ResponseEntity<List<Citizen>> getByVaccinationCenterId(@PathVariable Integer id){
		List<Citizen> citizens = citizenService.fetchCitizenList(id);
		return new ResponseEntity<>(citizens, HttpStatus.OK);
	}
	
	@PostMapping(path = "/add")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen){
		Citizen savedCitizen = citizenService.addCitizen(newCitizen);
		return new ResponseEntity<>(savedCitizen, HttpStatus.OK);
	}
}
