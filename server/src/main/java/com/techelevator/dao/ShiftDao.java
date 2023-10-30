package com.techelevator.dao;

import com.techelevator.model.Shift;

import java.util.List;

public interface ShiftDao {

    // Get shift from datastore by ID with client name
    Shift getShiftById(int shiftId);

    // Get all available shifts with client names
    List<Shift> getAvailableShifts(boolean isAvailable);

    // Get shifts from datastore by client ID with client names
    List<Shift> getShiftByClientId(int clientId, boolean isAvailable);

    // Get shifts from datastore by service ID with client names
    List<Shift> getShiftByServiceId(int serviceId, boolean isAvailable);

    // Get shifts from datastore by total hours with client names
    List<Shift> getShiftByTotalHours(int minHours, int maxHours, boolean isAvailable);

    // Get shifts from teh datastore by zipcode with client names
    List<Shift> getShiftByZipcode(String zipcode, boolean isAvailable);


}
