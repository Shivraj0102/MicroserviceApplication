package com.health.app.vaccinationcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health.app.vaccinationcenter.entities.VaccinationCenter;
import com.health.app.vaccinationcenter.model.VaccinationCenterDetail;
import com.health.app.vaccinationcenter.services.VaccinationCenterService;


@RestController
@RequestMapping("vaccinationcenter")
public class VaccinationCenterController {

	@Autowired
	private VaccinationCenterService centerService;
	
	@PostMapping(path = "/add")
	public ResponseEntity<VaccinationCenter> addCenter(@RequestBody VaccinationCenter center){
		System.out.println("vaccination center: "+ center);
		VaccinationCenter savedCenter = centerService.addCenter(center);
		return new ResponseEntity<>(savedCenter, HttpStatus.OK);
	}
	
	@GetMapping(path="/id/{centerId}")
	public ResponseEntity<VaccinationCenterDetail> getCenterById(@PathVariable Integer centerId){
		VaccinationCenterDetail centerDetail = centerService.getCenterDetail(centerId);
		return new ResponseEntity<>(centerDetail, HttpStatus.OK);
	}
}
