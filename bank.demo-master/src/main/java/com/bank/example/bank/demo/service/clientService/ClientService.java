package com.bank.example.bank.demo.service.clientService;

import com.bank.example.bank.demo.model.client.Client;
import com.bank.example.bank.demo.model.client.TypeClient;

import java.util.List;

public interface ClientService {
    void addClient(Client client);

    List<Client> loadAllClient();

    List<Client> findClientByFirstName(String firstName);

    List<Client> findClientByLastName(String lastName);

    Client findClientByIdnp(String idnp);

    Client findClientByID(long id);

    void deleteClientByID(long id);

    void updateClient(Client client);

    void updateStatusClient(long idClient, TypeClient typeClient);


}
