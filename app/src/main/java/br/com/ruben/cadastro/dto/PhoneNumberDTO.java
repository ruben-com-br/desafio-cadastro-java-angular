package br.com.ruben.cadastro.dto;

import br.com.ruben.cadastro.entity.Client;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

//@Validated
public class PhoneNumberDTO {

    private Long id;

    @NotBlank(message = "O telefone não pode ser nulo")
    @Pattern(regexp = "(\\d{10}|\\d{2}9\\d{8})", message = "Formato de telefone inválido. Deve ter 10 ou 11 dígitos.")
    private String number;

    private Client client;

    public PhoneNumberDTO() {
    }

    public PhoneNumberDTO(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
