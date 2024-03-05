package br.com.ruben.cadastro.repository;

import br.com.ruben.cadastro.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long>{

}