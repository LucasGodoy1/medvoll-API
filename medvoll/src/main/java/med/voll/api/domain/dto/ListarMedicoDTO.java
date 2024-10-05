package med.voll.api.domain.dto;

import med.voll.api.domain.entity.Medico;
import med.voll.api.domain.medico.Especialidade;

public record ListarMedicoDTO(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public ListarMedicoDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
