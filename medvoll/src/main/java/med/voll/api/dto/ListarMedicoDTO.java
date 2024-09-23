package med.voll.api.dto;

import med.voll.api.entity.Medico;
import med.voll.api.medico.Especialidade;

public record ListarMedicoDTO(String nome, String email, String crm, Especialidade especialidade) {

    public ListarMedicoDTO(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
