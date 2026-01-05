package com.d424.dao;

import com.d424.model.Services;

import java.util.List;

public interface ServiceDao {

    //get service from datastore by ID
    Services getServiceById(int in);

   // get service from datastore by name
    Services getServiceByName(String name);

    // get a list of all services
    List<Services> getServices();

}
