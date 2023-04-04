package com.insurance.service;

import java.util.List;


import com.insurance.dto.Insurance;

public interface InsuranceService {
	
	public Insurance createInsurance(Insurance insurance);
	public Insurance getInsuranceById(int insuranceId);
	public boolean deleteInsuranceById(int insuranceId);
	public List<Insurance> getAllInsurance();
	public Insurance updateInsurance(int insuranceId, Insurance insurance);

}
