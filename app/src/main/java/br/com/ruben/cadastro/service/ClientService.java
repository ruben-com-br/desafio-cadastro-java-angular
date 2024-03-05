package br.com.ruben.cadastro.service;

import br.com.ruben.cadastro.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();

    Client saveClient(Client student);

    Client getClientById(Long id);

    Client updateClient(Client student);

    void deleteClientById(Long id);
}