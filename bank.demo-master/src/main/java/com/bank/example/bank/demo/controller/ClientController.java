package com.bank.example.bank.demo.controller;

import com.bank.example.bank.demo.model.client.Client;
import com.bank.example.bank.demo.model.client.TypeClient;
import com.bank.example.bank.demo.service.clientService.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/add")
    public void addClient(@RequestBody Client client) {
        clientService.addClient(client);
    }

    @GetMapping("/all")
    public List<Client> getAllClient() {
        return clientService.loadAllClient();
    }

    @GetMapping("/firstname/{firstname}")
    List<Client> findClientByFirstName(@PathVariable String firstname){
        return clientService.findClientByFirstName(firstname);
    }

    @GetMapping("/lastname/{lastname}")
    List<Client> findClientByLastName(@PathVariable String lastname){
        return clientService.findClientByLastName(lastname);
    }
    @GetMapping("/idnp/{idnp}")
    Client findClientByIdnp(@PathVariable  String idnp){
        return clientService.findClientByIdnp(idnp);
    }

    @GetMapping("/id/{id}")
    Client getClientByID(@PathVariable long id){
        return clientService.findClientByID(id);
    }

    @DeleteMapping("id/{id}")
    void deleteClientByID(@PathVariable long id){
        clientService.deleteClientByID(id);
    }
    @PutMapping("/update")
    void updateClient(@RequestBody Client client){
        clientService.updateClient(client);
    }
    @GetMapping("/update/status/id_{id}/type_{typeClient}")
    void updateClientStatus(@PathVariable long id, @PathVariable TypeClient typeClient){
        clientService.updateStatusClient(id, typeClient);
    }


}
