package med.voll.api.domain.dto;


import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.entity.Medico;
import med.voll.api.domain.medico.Especialidade;

public record DadosDetalhamentoMedicoDTO(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoMedicoDTO (Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());

    }
}
