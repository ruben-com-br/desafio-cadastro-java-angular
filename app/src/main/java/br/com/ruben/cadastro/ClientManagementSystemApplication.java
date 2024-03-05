package br.com.ruben.cadastro;

import br.com.ruben.cadastro.entity.Client;
import br.com.ruben.cadastro.entity.PhoneNumber;
import br.com.ruben.cadastro.repository.ClientRepository;
import br.com.ruben.cadastro.repository.PhoneNumberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ClientManagementSystemApplication implements CommandLineRunner {

    private ClientRepository clientRepository;
    private PhoneNumberRepository phoneNumberRepository;

    public ClientManagementSystemApplication(ClientRepository clientRepository, PhoneNumberRepository phoneNumberRepository) {
        super();
        this.clientRepository = clientRepository;
        this.phoneNumberRepository = phoneNumberRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Client student1 = clientRepository.save(new Client("Joao da Silva", "Rua 90", "Centro"));
        phoneNumberRepository.save(new PhoneNumber("556291111001", student1));
        phoneNumberRepository.save(new PhoneNumber("556291111002", student1));

        Client student2 = clientRepository.save(new Client("Pedro Alvares Cabral", "Av. 136", "Jardim Goias"));
        phoneNumberRepository.save(new PhoneNumber("556292222001", student2));
        phoneNumberRepository.save(new PhoneNumber("556292222002", student2));

        Client student3 = clientRepository.save(new Client("Ruben Ramos", "Av. Nova York", "Jardim Novo Mundo"));
        phoneNumberRepository.save(new PhoneNumber("556293333001", student3));
        phoneNumberRepository.save(new PhoneNumber("556293333002", student3));

    }

}