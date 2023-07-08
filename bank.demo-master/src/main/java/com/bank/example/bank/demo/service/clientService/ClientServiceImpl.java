package com.bank.example.bank.demo.service.clientService;

import com.bank.example.bank.demo.model.client.Client;
import com.bank.example.bank.demo.model.client.TypeClient;
import com.bank.example.bank.demo.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;



    @Override
    public void addClient(Client client) {
        System.out.println("service add client ");
        clientRepository.save(client);
    }

    @Override
    public List<Client> loadAllClient() {
        System.out.println("service load all clients");
        return clientRepository.findAll();
    }

    @Override
    public List<Client> findClientByFirstName(String firstName) {
        System.out.println("service client find by firstName");
        List<Client> clientListFirstName = null;
        try {
            clientListFirstName = clientRepository.findClientByFirstName(firstName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
            //TODO: afisare erorii catre user eroare
        }
        return clientListFirstName;
    }

    @Override
    public List<Client> findClientByLastName(String lastName) {
        System.out.println("service client find by lastName");
        List<Client> clientListLastName = null;
        try {
            clientListLastName = clientRepository.findClientByLastName(lastName);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
            //TODO: afisare erorii catre user eroare
        }

        return clientListLastName;
    }

    @Override
    public Client findClientByIdnp(String idnp) {
        System.out.println("service for find by idnp");
        Client client = null;
        try {
            client = clientRepository.findClientByIdnp(idnp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public Client findClientByID(long id) {
        System.out.println("service find client by id");
        Client client = null;
        client = clientRepository.findById(id);

        return client;
    }

    @Override
    public void deleteClientByID(long id) {
        System.out.println("service delete client by id");
        clientRepository.deleteById(id);

    }

    @Override
    public void updateClient(Client client) {
        System.out.println("service update cllient ");

        Client exClient = clientRepository.findById(client.getIdClient());

        exClient.setIdClient(client.getIdClient());
        exClient.setFirstName(client.getFirstName());
        exClient.setLastName(client.getLastName());
        exClient.setIdnp(client.getIdnp());
        exClient.setIdnp(client.getIdnp());
        exClient.setPhoneNumber(client.getPhoneNumber());
        exClient.setTypeClient(client.getTypeClient());
        exClient.setTypeCurrensy(client.getTypeCurrensy());
        exClient.setAmountCurrency(client.getAmountCurrency());
        clientRepository.save(exClient);
    }

    @Override
    public void updateStatusClient(long idClient, TypeClient typeClient) {
        Client client = findClientByID(idClient);
        client.setTypeClient(typeClient);
        clientRepository.save(client);
    }


}
