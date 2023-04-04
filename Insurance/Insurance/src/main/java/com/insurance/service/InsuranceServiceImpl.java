package com.insurance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dto.Insurance;

import com.insurance.entity.InsuranceEntity;
import com.insurance.exception.InvalidInsuranceIdException;
import com.insurance.repository.InsuranceRepository;


@Service
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	InsuranceRepository insuranceRepo;

	@Override
	public Insurance createInsurance(Insurance insurance) {
		InsuranceEntity insuranceEntity = this.modelMapper.map(insurance, InsuranceEntity.class);
		insuranceEntity = insuranceRepo.save(insuranceEntity);
		Insurance insuranceDto = this.modelMapper.map(insuranceEntity, Insurance.class);
		return insuranceDto;
	}

	@Override
	public Insurance getInsuranceById(int insuranceId) {
		Optional<InsuranceEntity> opInsuranceEntity = insuranceRepo.findById(insuranceId);
		if (opInsuranceEntity.isPresent()) {
			InsuranceEntity insuranceEntity = opInsuranceEntity.get();
			Insurance insuranceDto = this.modelMapper.map(insuranceEntity, Insurance.class);
			return insuranceDto;
		}
		throw new InvalidInsuranceIdException(""+insuranceId);
	}

	@Override
	public boolean deleteInsuranceById(int insuranceId) {
		insuranceRepo.deleteById(insuranceId);
		return true;
	}

	@Override
	public List<Insurance> getAllInsurance() {
		List<InsuranceEntity> insuranceEntityList = insuranceRepo.findAll();
		return getinsuranceDtoList(insuranceEntityList);
	}

	private List<Insurance> getinsuranceDtoList(List<InsuranceEntity> insuranceEntityList) {
		List<Insurance> insuranceDtoList = new ArrayList<Insurance>();
		for (InsuranceEntity insuranceEntity : insuranceEntityList) {
			Insurance insuranceDto = this.modelMapper.map(insuranceEntity, Insurance.class);
			insuranceDtoList.add(insuranceDto);
		}
		return insuranceDtoList;
	}

	@Override
	public Insurance updateInsurance(int insuranceId, Insurance insurance) {
		Optional<InsuranceEntity> opInsuranceEntity = insuranceRepo.findById(insuranceId);
		if (opInsuranceEntity.isPresent()) {
			InsuranceEntity insuranceEntity = opInsuranceEntity.get();

			/*
			 * insuranceEntity.setPolicyNum(insurance.getPolicyNum());
			 * insuranceEntity.setType(insurance.getType());
			 * insuranceEntity.setCoverageAmount(insurance.getCoverageAmount());
			 * insuranceEntity.setPremium(insurance.getPremium());
			 * insuranceEntity.setStartDate(insurance.getStartDate());
			 * insuranceEntity.setEndDate(insurance.getEndDate());
			 */
			insuranceEntity.setId(insuranceId);
			insuranceEntity = this.modelMapper.map(insurance, InsuranceEntity.class);
			insuranceEntity = insuranceRepo.save(insuranceEntity);
			Insurance insuranceDto = this.modelMapper.map(insuranceEntity, Insurance.class);
			return insuranceDto;
		}
		throw new InvalidInsuranceIdException(""+insuranceId);
	}

}
