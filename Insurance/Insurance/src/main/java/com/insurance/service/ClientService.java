package com.insurance.service;

import java.util.List;


import com.insurance.dto.Client;

public interface ClientService {
	
	public Client createClient(Client client);
	public Client getClientById(int clientId);
	public boolean deleteClientById(int clientId);
	public List<Client> getAllClient();
	public Client updateClient(int clientId, Client client);
	

}
