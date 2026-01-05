package com.techelevator.dao;

import com.techelevator.model.Services;

import java.util.List;

public interface ServiceDao {

    //get service from datastore by ID
    Services getServiceById(int in);

   // get service from datastore by name
    Services getServiceByName(String name);

    // get a list of all services
    List<Services> getServices();

}
