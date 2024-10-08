package med.voll.api.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.dto.DadosAtualizacaoMedicoDTO;
import med.voll.api.domain.dto.DadosCadastroMedicoDTO;
import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.medico.Especialidade;

@Entity
@Table(name = "tb_medicos")
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedicoDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.dadosEndereco());
        this.ativo = true;
    }

    public void atualizarMedico(DadosAtualizacaoMedicoDTO dadosAtualizacaoMedicoDTO) {
        if(dadosAtualizacaoMedicoDTO.nome() != null){
            this.nome = dadosAtualizacaoMedicoDTO.nome();
        }

        if (dadosAtualizacaoMedicoDTO.telefone() != null) {
            this.telefone = dadosAtualizacaoMedicoDTO.telefone();
        }
        if (dadosAtualizacaoMedicoDTO.endereco() != null){
            this.endereco.atualizarEndereco(dadosAtualizacaoMedicoDTO.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
