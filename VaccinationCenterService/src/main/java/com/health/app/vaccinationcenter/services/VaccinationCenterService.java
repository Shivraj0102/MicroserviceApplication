package com.health.app.vaccinationcenter.services;

import com.health.app.vaccinationcenter.entities.VaccinationCenter;
import com.health.app.vaccinationcenter.model.VaccinationCenterDetail;

public interface VaccinationCenterService {

	VaccinationCenter addCenter(VaccinationCenter center);

	VaccinationCenterDetail getCenterDetail(Integer centerId);
	
}
