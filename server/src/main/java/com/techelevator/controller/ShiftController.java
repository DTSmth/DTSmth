package com.techelevator.controller;


import com.techelevator.dao.ShiftDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Shift;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/shifts")
//@PreAuthorize("isAuthenticated()")
public class ShiftController {
    private final ShiftDao shiftDao;

    public ShiftController(ShiftDao shiftDao) {
        this.shiftDao = shiftDao;
    }

    @GetMapping()
    public List<Shift> getAllShifts(
            @RequestParam(required = false) String serviceName,
            @RequestParam(required = false) Integer minHours,
            @RequestParam(required = false) Integer maxHours,
            @RequestParam(required = false) String zipcode,
            @RequestParam(required = false) String clientFirstName,
            @RequestParam(required = false) String clientLastName
    ) {
        if (serviceName != null && !serviceName.isEmpty()) {
            return shiftDao.getShiftByServiceName(serviceName);
        } else if (minHours != null && maxHours != null) {
            return shiftDao.getShiftByTotalHours(minHours, maxHours);
        } else if (zipcode != null) {
            return shiftDao.getShiftByZipcode(zipcode);
        } else if (clientFirstName != null && clientLastName != null) {
            return shiftDao.getShiftByClientName(clientFirstName, clientLastName);
        } else {
            return shiftDao.getAvailableShifts();
        }
    }

    @DeleteMapping("/{shiftId}")
    public void removeShift(@PathVariable int shiftId) {
        shiftDao.removeShift(shiftId);
    }

    @PostMapping()
    public Shift createShift(@RequestBody Shift shift) {
        try {
            return shiftDao.createShift(shift);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping
    public Shift updateShift(@RequestBody Shift shift) {
        try {
            return shiftDao.updateShift(shift);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/{shiftId}")
    public Shift getShiftById(@PathVariable int shiftId) {
        return shiftDao.getShiftById(shiftId);
    }

}
