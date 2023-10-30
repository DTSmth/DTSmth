package com.techelevator.dao;

import com.techelevator.model.ClientService;

import java.util.List;

public interface ClientServiceDao {

    // Get a list of all Services for a specific Client
    List<ClientService> getAllServicesForClientById (int id);

    // Get a list of all clients for a specific Service
    List<ClientService> getAllClientsForServiceById (int id, boolean isAvailable);

}
