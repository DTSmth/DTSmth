package com.d424.dao;

import com.d424.model.Client;

import java.util.List;

public interface ClientDao {

    //get a client from the datastore by id
    Client getClientById(int id);

    // get a list of all clients
    List<Client> getAllClients();

    // Find clients by first name and last name
    List<Client> getClientByFirstNameLastName(String firstname, String lastname);

    // Find client by zip code
    List<Client> getClientByZipCode(String zipcode);

    // Create a new client
    Client createClient(Client client);

    // Update a client
    Client updateClient(Client client);

    // Delete a client
    void deleteClient(int id);

}
