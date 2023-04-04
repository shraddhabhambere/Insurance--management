package com.insurance.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Client")
public class ClientEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private LocalDate dateOfBirth;
	private String address;
	private String contactInformation;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<InsuranceEntity> policies = new ArrayList<>();

	public ClientEntity() {
		super();
	}

	public ClientEntity(int id, String name, LocalDate dateOfBirth, String address, String contactInformation,
			List<InsuranceEntity> policies) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.contactInformation = contactInformation;
		this.policies = policies;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	public List<InsuranceEntity> getPolicies() {
		return policies;
	}

	public void setPolicies(List<InsuranceEntity> policies) {
		this.policies = policies;
	}

	@Override
	public String toString() {
		return "ClientEntity [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address
				+ ", contactInformation=" + contactInformation + ", policies=" + policies + "]";
	}
	
	
	
	

}
