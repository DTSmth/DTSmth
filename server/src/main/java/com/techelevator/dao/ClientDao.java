package com.techelevator.dao;

import com.techelevator.model.Client;

import java.util.List;

public interface ClientDao {

    //get a client from the datastore by id
    Client getClientById(int id);

    // get a list of all clients
    List<Client> getClients();

    // Find clients by first name and last name
    List<Client> getClientByFirstNameLastName(String firstname, String lastname);

    // Find client by zip code
    List<Client> getClientByZipCode(String zipcode);


}
