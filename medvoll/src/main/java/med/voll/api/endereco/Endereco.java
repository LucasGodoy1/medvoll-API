package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.dto.DadosEnderecoDTO;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;

    @Enumerated(EnumType.STRING)
    private UF uf;

    public Endereco(DadosEnderecoDTO dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
    }

    public void atualizarEndereco(DadosEnderecoDTO dadosEnderecoDTO) {
        if (dadosEnderecoDTO.logradouro()!= null){
            this.logradouro = dadosEnderecoDTO.logradouro();
        }
        if (dadosEnderecoDTO.bairro() != null){
            this.bairro = dadosEnderecoDTO.bairro();
        }

        if (dadosEnderecoDTO.cep()!= null){
            this.cep = dadosEnderecoDTO.cep();
        }
        if(dadosEnderecoDTO.uf() != null){
            this.uf = dadosEnderecoDTO.uf();
        }
        if (dadosEnderecoDTO.cidade() != null){
            this.cidade = dadosEnderecoDTO.cidade();
        }
        if (dadosEnderecoDTO.numero() != null){
            this.numero = dadosEnderecoDTO.numero();
        }
        if (dadosEnderecoDTO.complemento() != null){
            this.complemento = dadosEnderecoDTO.complemento();
        }

    }
}
