package com.insurance.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "insurance")
public class InsuranceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int policyNum;
	private String type;
	private double coverageAmount;
	private double premium;
	private LocalDate startDate;
	private LocalDate endDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false)
	private ClientEntity client;
	
	@OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
	private List<ClaimEntity> claims = new ArrayList<>();

	public InsuranceEntity() {
		super();
	}

	/**
	 * @param id
	 * @param policyNum
	 * @param type
	 * @param coverageAmount
	 * @param premium
	 * @param startDate
	 * @param endDate
	 * @param client
	 * @param claims
	 */
	public InsuranceEntity(int id, int policyNum, String type, double coverageAmount, double premium,
			LocalDate startDate, LocalDate endDate, ClientEntity client, List<ClaimEntity> claims) {
		super();
		this.id = id;
		this.policyNum = policyNum;
		this.type = type;
		this.coverageAmount = coverageAmount;
		this.premium = premium;
		this.startDate = startDate;
		this.endDate = endDate;
		this.client = client;
		this.claims = claims;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}

	public List<ClaimEntity> getClaims() {
		return claims;
	}

	public void setClaims(List<ClaimEntity> claims) {
		this.claims = claims;
	}

	@Override
	public String toString() {
		return "InsuranceEntity [id=" + id + ", policyNum=" + policyNum + ", type=" + type + ", coverageAmount="
				+ coverageAmount + ", premium=" + premium + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", client=" + client + ", claims=" + claims + "]";
	}
	
	



	

}
