package com.insurance.service;

import java.util.List;

import com.insurance.dto.Claim;


public interface ClaimService {
	
	public Claim createClaim(Claim claim);
	public Claim getClaimById(int claimId);
	public boolean deleteClaimById(int claimId);
	public List<Claim> getAllClaim();
	public Claim updateClaim(int claimId, Claim claim);

}
