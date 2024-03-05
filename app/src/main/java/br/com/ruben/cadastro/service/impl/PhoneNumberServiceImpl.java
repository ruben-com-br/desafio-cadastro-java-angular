package br.com.ruben.cadastro.service.impl;

import br.com.ruben.cadastro.entity.Client;
import br.com.ruben.cadastro.entity.PhoneNumber;
import br.com.ruben.cadastro.repository.PhoneNumberRepository;
import br.com.ruben.cadastro.service.PhoneNumberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {

    private PhoneNumberRepository phoneNumberRepository;

    public PhoneNumberServiceImpl(PhoneNumberRepository phoneNumberRepository) {
        super();
        this.phoneNumberRepository = phoneNumberRepository;
    }

    @Override
    public List<PhoneNumber> getAllPhoneNumbers() {
        return phoneNumberRepository.findAll();
    }

    @Override
    public PhoneNumber savePhoneNumber(PhoneNumber phoneNumber) {
        return phoneNumberRepository.save(phoneNumber);
    }

    @Override
    public PhoneNumber getPhoneNumberById(Long id) {
        return phoneNumberRepository.findById(id).get();
    }

    @Override
    public PhoneNumber updatePhoneNumber(PhoneNumber phoneNumber) {
        return phoneNumberRepository.save(phoneNumber);
    }

    @Override
    public void deletePhoneNumberById(Long id) {
        phoneNumberRepository.deleteById(id);
    }

    @Override
    public List<PhoneNumber> getPhoneNumberByClient(Client client) {
        return phoneNumberRepository.findAllByClient(client);
    }

}