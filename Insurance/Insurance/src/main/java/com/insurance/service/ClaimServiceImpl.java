package com.insurance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dto.Claim;

import com.insurance.entity.ClaimEntity;
import com.insurance.exception.InvalidInsuranceIdException;
import com.insurance.repository.ClaimRepository;


@Service
public class ClaimServiceImpl implements ClaimService{
	
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	ClaimRepository claimRepo;

	@Override
	public Claim createClaim(Claim claim) {
		ClaimEntity claimEntity = this.modelMapper.map(claim, ClaimEntity.class);
		claimEntity = claimRepo.save(claimEntity);
		Claim claimDto = this.modelMapper.map(claimEntity, Claim.class);
		return claimDto;
	}

	@Override
	public Claim getClaimById(int claimId) {
		Optional<ClaimEntity> opClaimEntity = claimRepo.findById(claimId);
		if (opClaimEntity.isPresent()) {
			ClaimEntity claimEntity = opClaimEntity.get();
			Claim claimDto = this.modelMapper.map(claimEntity, Claim.class);
			return claimDto;
		}
		throw new InvalidInsuranceIdException(""+claimId);
	}

	@Override
	public boolean deleteClaimById(int claimId) {
		claimRepo.deleteById(claimId);
		return true;
	}

	@Override
	public List<Claim> getAllClaim() {
		List<ClaimEntity> claimEntityList = claimRepo.findAll();
		return getClaimDtoList(claimEntityList);
	}

	private List<Claim> getClaimDtoList(List<ClaimEntity> claimEntityList) {
		List<Claim> claimDtoList = new ArrayList<Claim>();
		for (ClaimEntity claimEntity : claimEntityList) {
			Claim claimDto = this.modelMapper.map(claimEntity, Claim.class);
			claimDtoList.add(claimDto);
		}
		return claimDtoList;
	}

	@Override
	public Claim updateClaim(int claimId, Claim claim) {
		Optional<ClaimEntity> opClaimEntity = claimRepo.findById(claimId);
		if (opClaimEntity.isPresent()) {
			ClaimEntity claimEntity = opClaimEntity.get();

			
			
			/*claimEntity.setClaimNumber(claim.getClaimNumber());
			claimEntity.setDescription(claim.getDescription());
			claimEntity.setClaimDate(claim.getClaimDate());
			claimEntity.setClaimStatus(claim.getClaimStatus());
			*/
			claimEntity.setId(claimId);
			claimEntity = this.modelMapper.map(claim, ClaimEntity.class);
			claimEntity = claimRepo.save(claimEntity);
			Claim claimDto = this.modelMapper.map(claimEntity, Claim.class);
			return claimDto;
		}
		throw new InvalidInsuranceIdException(""+claimId);
	}

}
