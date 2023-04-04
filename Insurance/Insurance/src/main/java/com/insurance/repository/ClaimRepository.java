package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.entity.ClaimEntity;



public interface ClaimRepository extends JpaRepository<ClaimEntity, Integer> {

}
