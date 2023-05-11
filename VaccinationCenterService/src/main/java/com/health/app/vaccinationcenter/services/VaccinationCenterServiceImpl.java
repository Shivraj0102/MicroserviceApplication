package com.health.app.vaccinationcenter.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.health.app.vaccinationcenter.entities.VaccinationCenter;
import com.health.app.vaccinationcenter.model.Citizen;
import com.health.app.vaccinationcenter.model.VaccinationCenterDetail;
import com.health.app.vaccinationcenter.repositories.VaccinationCenterRepository;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {

	@Autowired
	private VaccinationCenterRepository centerRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public VaccinationCenter addCenter(VaccinationCenter center) {
		return centerRepo.save(center);
	}

	@Override
	public VaccinationCenterDetail getCenterDetail(Integer centerId) {
		VaccinationCenterDetail centerDetail = new VaccinationCenterDetail();
		VaccinationCenter center = centerRepo.findById(centerId).get();
		centerDetail.setCenter(center);
		
		List<Citizen> citizens = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/vaccination-center-id/"+centerId, List.class);
		centerDetail.setCitizens(citizens);
		
		return centerDetail;
	}

}
