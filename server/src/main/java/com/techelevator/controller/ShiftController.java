package com.techelevator.controller;


import com.techelevator.dao.ShiftDao;
import com.techelevator.model.Shift;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/shifts")
@PreAuthorize("isAuthenticated()")
public class ShiftController {
    private final ShiftDao shiftDao;

    public ShiftController(ShiftDao shiftDao) {
        this.shiftDao = shiftDao;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Shift> getAllShifts(@RequestParam(defaultValue = "") String serviceName) {

        if (!serviceName.equals("")) {
            return shiftDao.getShiftByServiceName(serviceName);
        }

        return shiftDao.getAvailableShifts(true);
    }


    @RequestMapping(path = "/byTotalHours", method = RequestMethod.GET)
    public List<Shift> getShiftsByTotalHours(
            @RequestParam int minHours,
            @RequestParam int maxHours,
            @RequestParam boolean isAvailable
    ) {
        return shiftDao.getShiftByTotalHours(minHours, maxHours, isAvailable);
    }

    @RequestMapping(path = "/byZipcode", method = RequestMethod.GET)
    public List<Shift> getShiftsByZipcode(
            @RequestParam String zipcode,
            @RequestParam boolean isAvailable
    ) {
        return shiftDao.getShiftByZipcode(zipcode, isAvailable);
    }

    @DeleteMapping("/{shiftId}")
    public void removeShift(@PathVariable int shiftId) {
        shiftDao.removeShift(shiftId);
    }

    @PostMapping()
    public Shift createShift(@RequestBody Shift shift) {
        return shiftDao.createShift(shift);
    }

}
