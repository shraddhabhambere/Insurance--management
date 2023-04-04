package com.insurance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insurance.dto.Client;
import com.insurance.entity.ClientEntity;
import com.insurance.exception.InvalidInsuranceIdException;
import com.insurance.repository.ClientRepository;


@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ClientRepository clientrepo;

	@Override
	public Client createClient(Client client) {
		ClientEntity clientEntity =this.modelMapper.map(client, ClientEntity.class);
		clientEntity =clientrepo.save(clientEntity);
		Client clientDto=this.modelMapper.map(clientEntity, Client.class);
		return clientDto;
		
	}

	@Override
	public Client getClientById(int clientId) {
		Optional<ClientEntity> opClientEntity =clientrepo.findById(clientId);
		if(opClientEntity.isPresent() ) {
			ClientEntity clientEntity = opClientEntity.get();
			Client clientDto = this.modelMapper.map(clientEntity, Client.class);
			return clientDto;
		}
		throw new InvalidInsuranceIdException(""+clientId);
	}
	


	@Override
	public boolean deleteClientById(int clientId) {
		clientrepo.deleteById(clientId);
		return true;
		
	}

	@Override
	public List<Client> getAllClient() {
		List<ClientEntity> clientEntityList = clientrepo.findAll();
		return getClientDtoList(clientEntityList);
	}
	
	private List<Client> getClientDtoList(List<ClientEntity> clientEntityList) {
		List <Client> clientDtoList = new ArrayList<Client>();
		for(ClientEntity clientEntity: clientEntityList) {
			Client clientDto = this.modelMapper.map(clientEntity, Client.class);
			clientDtoList.add(clientDto);
		}
		return clientDtoList;
	}

	@Override
	public Client updateClient(int clientId, Client client) {
		Optional<ClientEntity> opClientEntity =clientrepo.findById(clientId);
		if(opClientEntity.isPresent()) {
			ClientEntity clientEntity = opClientEntity.get();
			
			
			/*clientEntity.setName(client.getName());
			clientEntity.setDateOfBirth(client.getDateOfBirth());
			clientEntity.setAddress(client.getAddress());
			clientEntity.setContactInformation(client.getContactInformation());
			*/
			
			clientEntity.setId(clientId);
			clientEntity =this.modelMapper.map(client, ClientEntity.class);
			clientEntity =clientrepo.save(clientEntity);
			Client clientDto=this.modelMapper.map(clientEntity, Client.class);
			return clientDto;
		}
		throw new InvalidInsuranceIdException(""+clientId);
		
	}



	
	
	
	
	
	
	

}
