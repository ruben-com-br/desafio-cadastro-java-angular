package br.com.ruben.cadastro.controllerThymeleaf;

import br.com.ruben.cadastro.dto.ClientDTO;
import br.com.ruben.cadastro.entity.Client;
import br.com.ruben.cadastro.entity.PhoneNumber;
import br.com.ruben.cadastro.service.ClientService;
import br.com.ruben.cadastro.service.PhoneNumberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;


@Controller
public class ClientController {

    private ClientService clientService;
    private PhoneNumberService phoneNumberService;

    public ClientController(ClientService clientService, PhoneNumberService phoneNumberService) {
        super();
        this.clientService = clientService;
        this.phoneNumberService = phoneNumberService;
    }

    @GetMapping("/clients")
    public String listClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "clients";
    }

    @GetMapping("/clients/new")
    public String createClientForm(Model model) {

        ClientDTO client = new ClientDTO();
        model.addAttribute("client", client);
        return "create_client";

    }

    @PostMapping("/clients")
    public String saveClient(@ModelAttribute("client") ClientDTO clientDTO) {

        Client client = new Client(
                clientDTO.getName(),
                clientDTO.getAddress(),
                clientDTO.getDistrict()
        );

        Client clientSaved = clientService.saveClient(client);

        for (String phoneNumber : Arrays.asList(clientDTO.getPhone1(), clientDTO.getPhone2())) {
            phoneNumberService.savePhoneNumber(new PhoneNumber(phoneNumber, clientSaved));
        }

        return "redirect:/clients";
    }

    @GetMapping("/clients/edit/{id}")
    public String editClientForm(@PathVariable Long id, Model model) {
        model.addAttribute("client", clientService.getClientById(id));
        return "edit_client";
    }

    @PostMapping("/clients/{id}")
    public String updateClient(@PathVariable Long id,
                                @ModelAttribute("client") ClientDTO clientDTO,
                                Model model) {

        Client existingClient = clientService.getClientById(id);
        existingClient.setId(id);
        existingClient.setName(clientDTO.getName());
        existingClient.setAddress(clientDTO.getAddress());
        existingClient.setDistrict(clientDTO.getDistrict());

        clientService.updateClient(existingClient);
        return "redirect:/clients";
    }

    @GetMapping("/clients/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClientById(id);
        return "redirect:/clients";
    }
}
