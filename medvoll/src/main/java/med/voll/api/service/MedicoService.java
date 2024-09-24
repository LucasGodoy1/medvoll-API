package med.voll.api.service;

import lombok.RequiredArgsConstructor;
import med.voll.api.dto.DadosAtualizacaoMedicoDTO;
import med.voll.api.dto.DadosCadastroMedicoDTO;
import med.voll.api.dto.DadosEnderecoDTO;
import med.voll.api.dto.ListarMedicoDTO;
import med.voll.api.entity.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {
    private final MedicoRepository medicoRepository;

    @Transactional
    public void salvarMedico(DadosCadastroMedicoDTO dados) {
        var medico = new Medico(dados);
        medicoRepository.save(medico);
    }

    @Transactional
    public Page<ListarMedicoDTO> listarMedicos(Pageable pageable) {
        return medicoRepository.findAllByAtivoTrue(pageable).map(ListarMedicoDTO::new);
    }

    @Transactional
    public void atualizarMedico(DadosAtualizacaoMedicoDTO dadosAtualizacaoMedicoDTO) {
       var medico = medicoRepository.getReferenceById(dadosAtualizacaoMedicoDTO.id());
       medico.atualizarMedico(dadosAtualizacaoMedicoDTO);
    }
    @Transactional
    public void desativarPorID(Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
    }

    @Transactional
    public void deletePorID(Long id) {
        medicoRepository.deleteById(id);
    }

}
