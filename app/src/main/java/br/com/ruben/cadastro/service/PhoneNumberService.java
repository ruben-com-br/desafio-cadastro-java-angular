package br.com.ruben.cadastro.service;

import br.com.ruben.cadastro.entity.Client;
import br.com.ruben.cadastro.entity.PhoneNumber;

import java.util.List;

public interface PhoneNumberService {
    List<PhoneNumber> getAllPhoneNumbers();

    PhoneNumber savePhoneNumber(PhoneNumber phoneNumber);

    PhoneNumber getPhoneNumberById(Long id);

    PhoneNumber updatePhoneNumber(PhoneNumber phoneNumber);

    void deletePhoneNumberById(Long id);

    List<PhoneNumber> getPhoneNumberByClient(Client client);
}
