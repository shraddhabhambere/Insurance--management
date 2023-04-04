package com.insurance.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Claim")
public class ClaimEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int claimNumber;
	private String description;
	private LocalDate claimDate;
	private String claimStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "policy_id" , nullable = false)
	private InsuranceEntity policy;

	public ClaimEntity() {
		super();
	}

	public ClaimEntity(int id, int claimNumber, String description, LocalDate claimDate, String claimStatus,
			InsuranceEntity policy) {
		super();
		this.id = id;
		this.claimNumber = claimNumber;
		this.description = description;
		this.claimDate = claimDate;
		this.claimStatus = claimStatus;
		this.policy = policy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public InsuranceEntity getPolicy() {
		return policy;
	}

	public void setPolicy(InsuranceEntity policy) {
		this.policy = policy;
	}

	@Override
	public String toString() {
		return "ClaimEntity [id=" + id + ", claimNumber=" + claimNumber + ", description=" + description
				+ ", claimDate=" + claimDate + ", claimStatus=" + claimStatus + ", policy=" + policy + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
