package com.bank.example.bank.demo.repository;

import com.bank.example.bank.demo.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findClientByFirstName(String firstName) throws SQLException;

    List<Client> findClientByLastName(String firstName) throws SQLException;

    Client findClientByIdnp(String idnp) throws SQLException;

    Client findById(long id);


}
