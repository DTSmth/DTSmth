package com.techelevator.service;

import com.techelevator.dao.ClientRepository;
import com.techelevator.model.Client;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(int id) {
        return clientRepository.findById(id);
    }

    public List<Client> getClientByFirstNameLastName(String first, String last) {
        return clientRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(first, last);
    }

    public List<Client> getClientByZipcode(String zipcode) {
        return clientRepository.findByZipcode(zipcode);
    }

    public List<Client> getClientsWithPersonalCare() {
        return clientRepository.findByHasPersonalCareTrue();
    }

    public List<Client> getClientsWithLifting() {
        return clientRepository.findByHasLiftingTrue();
    }

    @Transactional
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    public void deleteClient(int id) {
        clientRepository.deleteById(id);
    }
}
