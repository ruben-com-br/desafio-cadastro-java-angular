package br.com.ruben.cadastro.controllerThymeleaf;

import br.com.ruben.cadastro.dto.PhoneNumberDTO;
import br.com.ruben.cadastro.service.PhoneNumberService;
import br.com.ruben.cadastro.entity.Client;
import br.com.ruben.cadastro.entity.PhoneNumber;
import br.com.ruben.cadastro.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PhoneNumberController {

    private ClientService clientService;
    private PhoneNumberService phoneNumberService;

    public PhoneNumberController(ClientService clientService, PhoneNumberService phoneNumberService) {
        super();
        this.clientService = clientService;
        this.phoneNumberService = phoneNumberService;
    }

    @GetMapping("/phonenumbers/show/{id}")
    public String listPhoneNumbers(@PathVariable Long id, Model model) {
        Client client = clientService.getClientById(id);
        model.addAttribute("list", phoneNumberService.getPhoneNumberByClient(client));
        model.addAttribute("client", client);
        return "phonenumbers";
    }


    @GetMapping("/phonenumbers/delete/{id}")
    public String deletePhoneNumber(@PathVariable Long id) {
        PhoneNumber phoneNumber = phoneNumberService.getPhoneNumberById(id);
        Long clientId = phoneNumber.getClient().getId();
        phoneNumberService.deletePhoneNumberById(phoneNumber.getId());
        return "redirect:/phonenumbers/show/" + clientId;
    }

    @GetMapping("/phonenumbers/edit/{id}")
    public String editPhoneNumberForm(@PathVariable Long id, Model model) {
        PhoneNumber phoneNumber = phoneNumberService.getPhoneNumberById(id);
        model.addAttribute("phonenumber", phoneNumber);
        return "edit_phone_number";
    }

    @PostMapping("/phonenumbers/update/{id}")
    public String updatePhoneNumber(@PathVariable Long id,
                                    @ModelAttribute("phonenumber") PhoneNumberDTO phoneNumberDTO,
                                    Model model) {

        PhoneNumber phoneNumber = phoneNumberService.getPhoneNumberById(id);
        phoneNumber.setNumber(phoneNumberDTO.getNumber());

        phoneNumberService.updatePhoneNumber(phoneNumber);

        Long clientId = phoneNumber.getClient().getId();
        return "redirect:/phonenumbers/show/" + clientId;
    }

    @GetMapping("/phonenumbers/new/{id}")
    public String createClientForm(@PathVariable Long id,
                                   Model model) {
        Client client = clientService.getClientById(id);
        PhoneNumberDTO phoneNumberDTO = new PhoneNumberDTO();
        model.addAttribute("phonenumber", phoneNumberDTO);
        model.addAttribute("client", client);
        return "create_phone_number";

    }

    @PostMapping("/phonenumbers/{id}")
    public String saveClient(@PathVariable Long id,
                             @ModelAttribute("phonenumber") PhoneNumberDTO phoneNumberDTO) {

        phoneNumberService.savePhoneNumber(
                new PhoneNumber(
                        phoneNumberDTO.getNumber(),
                        phoneNumberDTO.getClient()
                )
        );

        return ("redirect:/phonenumbers/show/" + id);
    }

    @PostMapping("/phonenumbers/new/{id}")
    public String savePhoneNumber(@PathVariable Long id,
                                  @ModelAttribute("phonedto") PhoneNumberDTO phoneNumberDTO) {

        Client client = clientService.getClientById(id);
        phoneNumberService.savePhoneNumber(new PhoneNumber(phoneNumberDTO.getNumber(), client));

        return "redirect:/phonenumbers/show/" + id;
    }

}