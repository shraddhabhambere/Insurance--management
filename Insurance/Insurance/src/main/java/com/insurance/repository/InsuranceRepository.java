package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.entity.InsuranceEntity;



public interface InsuranceRepository extends JpaRepository<InsuranceEntity, Integer>{

}
