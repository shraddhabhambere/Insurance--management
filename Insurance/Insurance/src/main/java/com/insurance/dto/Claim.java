package com.insurance.dto;

import java.time.LocalDate;



import lombok.Data;

@Data
public class Claim {
	private int claimNumber;
	private String description;
	private LocalDate claimDate;
	private String claimStatus;
	public Claim() {
		super();
	}
	public Claim(int claimNumber, String description, LocalDate claimDate, String claimStatus) {
		super();
		this.claimNumber = claimNumber;
		this.description = description;
		this.claimDate = claimDate;
		this.claimStatus = claimStatus;
	}
	public int getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(int claimNumber) {
		this.claimNumber = claimNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	@Override
	public String toString() {
		return "Client [claimNumber=" + claimNumber + ", description=" + description + ", claimDate=" + claimDate
				+ ", claimStatus=" + claimStatus + "]";
	}
	
	

}
