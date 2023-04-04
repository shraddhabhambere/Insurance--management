package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.dto.Claim;
import com.insurance.dto.Client;
import com.insurance.dto.Insurance;
import com.insurance.service.ClaimService;
import com.insurance.service.ClientService;
import com.insurance.service.InsuranceService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class InsuranceController {
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	InsuranceService insuranceService;
	
	@Autowired
	ClaimService claimService;
	
	@DeleteMapping(value="/clints/{clientId}") 
	public boolean deleteClientById(@PathVariable("clientId") int clientId) {
		return clientService.deleteClientById(clientId);
	}
	
	@PutMapping(value="/clints/{clientId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Client updateClient(@PathVariable("clientId") int clientId, @RequestBody Client client) {
		return clientService.updateClient(clientId, client);
	}
	
	@PostMapping(value="clints", 
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	
	public @ResponseBody ResponseEntity<Client> createNewClient(@RequestBody Client client) {
		client = clientService.createClient(client);
		return new ResponseEntity(client, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/clints/{clientId}")
	public Client getClientById(@PathVariable("clientId") int clientId) {
		return clientService.getClientById(clientId);
	}

	@GetMapping(value="/clints", produces = MediaType.APPLICATION_JSON_VALUE)
	
	public List<Client> getAllClient() {
		return clientService.getAllClient();
	}
	
	@DeleteMapping(value="/policies/{insuranceId}") 
	public boolean deleteInsuranceById(@PathVariable("insuranceId") int insuranceId) {
		return insuranceService.deleteInsuranceById(insuranceId);
	}
	
	@PutMapping(value="/policies/{insuranceId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Insurance updateInsurance(@PathVariable("insuranceId") int insuranceId, @RequestBody Insurance insurance) {
		return insuranceService.updateInsurance(insuranceId, insurance);
	}
	
	@PostMapping(value="policies", 
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	
	public @ResponseBody ResponseEntity<Insurance> createNewPolicie(@RequestBody Insurance insurance) {
		insurance = insuranceService.createInsurance(insurance);
		return new ResponseEntity(insurance, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/policies/{insuranceId}")
	public Insurance getPolicieById(@PathVariable("insuranceId") int insuranceId) {
		return insuranceService.getInsuranceById(insuranceId);
	}

	@GetMapping(value="/policies", produces = MediaType.APPLICATION_JSON_VALUE)
	
	public List<Insurance> getAllPolicie() {
		return insuranceService.getAllInsurance();
	}
	
	@DeleteMapping(value="/claims/{claimId}") 
	public boolean deleteClaimById(@PathVariable("claimId") int claimId) {
		return claimService.deleteClaimById(claimId);
	}
	
	@PutMapping(value="/claims/{claimId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Claim updateInsurance(@PathVariable("claimId") int claimId, @RequestBody Claim claim) {
		return claimService.updateClaim(claimId, claim);
	}
	
	@PostMapping(value="claims", 
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	
	public @ResponseBody ResponseEntity<Claim> createNewClaim(@RequestBody Claim claim) {
		claim = claimService.createClaim(claim);
		return new ResponseEntity(claim, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/claims/{claimId}")
	public Claim getClaimsById(@PathVariable("claimId") int claimId) {
		return claimService.getClaimById(claimId);
	}

	@GetMapping(value="/claims", produces = MediaType.APPLICATION_JSON_VALUE)
	
	public List<Claim> getAllClaims() {
		return claimService.getAllClaim();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
