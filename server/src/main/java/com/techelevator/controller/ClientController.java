package com.techelevator.controller;

import com.techelevator.dao.ClientDao;
import com.techelevator.model.Client;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/clients")
@PreAuthorize("isAuthenticated()")
public class ClientController {

    private final ClientDao clientDao;

    public ClientController(ClientDao clientDao) {
        this.clientDao = clientDao;
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






}
