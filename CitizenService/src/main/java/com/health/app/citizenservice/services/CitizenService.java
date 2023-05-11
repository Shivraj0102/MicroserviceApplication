package com.health.app.citizenservice.services;

import java.util.List;

import com.health.app.citizenservice.entity.Citizen;

public interface CitizenService {

	List<Citizen> fetchCitizenList(Integer vaccinationCenterId);

	Citizen addCitizen(Citizen newCitizen);
}
