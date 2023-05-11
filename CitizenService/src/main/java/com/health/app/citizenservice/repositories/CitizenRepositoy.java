package com.health.app.citizenservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.app.citizenservice.entity.Citizen;

public interface CitizenRepositoy extends JpaRepository<Citizen, Integer>{
	
	public List<Citizen> findByVaccinationCenterId(Integer id);

}
