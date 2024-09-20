package med.voll.api.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.UF;

public record DadosEnderecoDTO(
                               @NotBlank
                               String logradouro,

                               @NotBlank
                               String bairro,

                               @NotBlank
                               @Pattern(regexp = "\\d{8}")
                               String cep,
                               @NotBlank
                               String cidade,
                               @NotNull
                               UF uf,
                               String complemento,
                               String numero) {

}

