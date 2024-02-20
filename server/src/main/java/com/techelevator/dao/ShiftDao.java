package com.techelevator.dao;

import com.techelevator.model.Shift;

import java.util.List;

public interface ShiftDao {

    // Get shift from datastore by ID with client name
    Shift getShiftById(int shiftId);

    // Get all available shifts with client names
    List<Shift> getAvailableShifts();

    // Get shifts from datastore by client ID with client names
    List<Shift> getShiftByClientId(int clientId);

    // Get shifts from datastore by service ID with client names
    List<Shift> getShiftByServiceName(String serviceName);

    // Get shifts from datastore by total hours with client names
    List<Shift> getShiftByTotalHours(int minHours, int maxHours);

    // Get shifts from the datastore by zipcode with client names
    List<Shift> getShiftByZipcode(String zipcode);

    // Get shifts from the datastore by client name with client names
    List<Shift> getShiftByClientName(String firstName, String lastName);

    // Remove a shift from datastore by its ID
    public void removeShift (int shiftId);

    Shift createShift(Shift shift);

    Shift updateShift(Shift shift);

    List<Shift> getShiftByClientID(int clientId);

}
