package med.voll.api.service;

import lombok.RequiredArgsConstructor;
import med.voll.api.dto.DadosCadastroMedicoDTO;
import med.voll.api.entity.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MedicoService {
    private final MedicoRepository medicoRepository;

    @Transactional
    public void salvarMedico(DadosCadastroMedicoDTO dados) {
        var medico = new Medico(dados);
        medicoRepository.save(medico);
    }

}
