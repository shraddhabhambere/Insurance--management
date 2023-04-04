package com.insurance.dto;

import java.time.LocalDate;

import lombok.Data;


@Data
public class Insurance {
	
	private int policyNum;
	private String type;
	private double coverageAmount;
	private double premium;
	private LocalDate startDate;
	private LocalDate endDate;
	public Insurance() {
		super();
	}
	public Insurance(int policyNum, String type, double coverageAmount, double premium, LocalDate startDate,
			LocalDate endDate) {
		super();
		this.policyNum = policyNum;
		this.type = type;
		this.coverageAmount = coverageAmount;
		this.premium = premium;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public int getPolicyNum() {
		return policyNum;
	}
	public void setPolicyNum(int policyNum) {
		this.policyNum = policyNum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getCoverageAmount() {
		return coverageAmount;
	}
	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "InsurancePolicy [policyNum=" + policyNum + ", type=" + type + ", coverageAmount=" + coverageAmount
				+ ", premium=" + premium + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	

}
