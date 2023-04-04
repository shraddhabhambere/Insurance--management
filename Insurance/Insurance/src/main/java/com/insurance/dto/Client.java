package com.insurance.dto;

import java.time.LocalDate;

import lombok.Data;
@Data
public class Client{
	
	private String name;
	private LocalDate dateOfBirth;
	private String address;
	private String contactInformation;
	public Client() {
		super();
	}
	public Client(String name, LocalDate dateOfBirth, String address, String contactInformation) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.contactInformation = contactInformation;
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
	@Override
	public String toString() {
		return "Claim [name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", contactInformation="
				+ contactInformation + "]";
	}
	
	

}
