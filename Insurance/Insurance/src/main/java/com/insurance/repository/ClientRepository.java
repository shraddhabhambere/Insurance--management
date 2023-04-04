package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.insurance.entity.ClientEntity;


public interface ClientRepository extends JpaRepository<ClientEntity, Integer>{

}
