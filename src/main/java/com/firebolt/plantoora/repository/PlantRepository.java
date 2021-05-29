package com.firebolt.plantoora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firebolt.plantoora.entity.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer>{

}
