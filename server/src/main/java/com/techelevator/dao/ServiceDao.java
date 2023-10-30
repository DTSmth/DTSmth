package com.techelevator.dao;

import com.techelevator.model.Service;

import java.util.List;

public interface ServiceDao {

    //get service from datastore by ID
    Service getServiceById(int in);

   // get service from datastore by name
    Service getServiceByName(String name);

    // get a list of all services
    List<Service> getServices();

}
