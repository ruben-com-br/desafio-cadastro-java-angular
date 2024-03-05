package br.com.ruben.cadastro.repository;

import br.com.ruben.cadastro.entity.Client;
import br.com.ruben.cadastro.entity.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long>{

    List<PhoneNumber> findAllByClient(Client client);

}