package com.health.app.vaccinationcenter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.app.vaccinationcenter.entities.VaccinationCenter;

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer> {

}
