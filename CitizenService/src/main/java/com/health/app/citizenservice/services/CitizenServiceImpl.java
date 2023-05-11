package com.health.app.citizenservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.app.citizenservice.entity.Citizen;
import com.health.app.citizenservice.repositories.CitizenRepositoy;

@Service
public class CitizenServiceImpl implements CitizenService {
	
	@Autowired
	private CitizenRepositoy citizenRepo;

	@Override
	public List<Citizen> fetchCitizenList(Integer vaccinationCenterId) {
		return citizenRepo.findByVaccinationCenterId(vaccinationCenterId);
	}

	@Override
	public Citizen addCitizen(Citizen newCitizen) {
		return citizenRepo.save(newCitizen);
	}

}
