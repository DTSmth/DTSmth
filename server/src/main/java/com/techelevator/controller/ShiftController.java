package com.techelevator.controller;


import com.techelevator.dao.ShiftDao;
import com.techelevator.model.Shift;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/shifts")
public class ShiftController {
    private final ShiftDao shiftDao;

    public ShiftController(ShiftDao shiftDao) {
        this.shiftDao = shiftDao;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Shift> getAllShifts() {
        return shiftDao.getAvailableShifts(true);
    }

}
