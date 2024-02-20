package com.techelevator.controller;

import com.techelevator.dao.ClientDao;
import com.techelevator.dao.ShiftDao;
import com.techelevator.model.Client;
import com.techelevator.model.Shift;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/clients")
//@PreAuthorize("isAuthenticated()")
public class ClientController {

    private final ClientDao clientDao;
    private final ShiftDao shiftDao;

    public ClientController(ClientDao clientDao, ShiftDao shiftDao) {
        this.clientDao = clientDao;
        this.shiftDao = shiftDao;
    }

    @GetMapping()
    public List<Client> getAllClients(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String zipcode
    ) {
        if (firstName != null && lastName != null) {
            return clientDao.getClientByFirstNameLastName(firstName, lastName);
        } else if (zipcode != null) {
            return clientDao.getClientByZipCode(zipcode);
        }
        return clientDao.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable int id) {
        return clientDao.getClientById(id);
    }

    @PostMapping()
    public Client createClient(@RequestBody Client client) {
        return clientDao.createClient(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable int id, @RequestBody Client client) {
        client.setClientId(id);
        return clientDao.updateClient(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable int id) {
    	clientDao.deleteClient(id);
    }

    @GetMapping("/{id}/shifts")
    public List<Shift> getClientShiftsById(@PathVariable int id) {
        return shiftDao.getShiftByClientID(id);
    }

}
