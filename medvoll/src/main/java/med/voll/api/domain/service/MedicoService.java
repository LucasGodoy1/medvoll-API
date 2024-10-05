package med.voll.api.domain.service;

import lombok.RequiredArgsConstructor;
import med.voll.api.domain.dto.DadosAtualizacaoMedicoDTO;
import med.voll.api.domain.dto.DadosCadastroMedicoDTO;
import med.voll.api.domain.dto.DadosDetalhamentoMedicoDTO;
import med.voll.api.domain.dto.ListarMedicoDTO;
import med.voll.api.domain.entity.Medico;
import med.voll.api.domain.repository.MedicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MedicoService {
    private final MedicoRepository medicoRepository;

    @Transactional
    public DadosDetalhamentoMedicoDTO salvarMedico(DadosCadastroMedicoDTO dados) {
        var medico = new Medico(dados);
        medicoRepository.save(medico);
        return new DadosDetalhamentoMedicoDTO(medico);
    }

    @Transactional
    public Page<ListarMedicoDTO> listarMedicos(Pageable pageable) {
        return medicoRepository.findAllByAtivoTrue(pageable).map(ListarMedicoDTO::new);
    }

    @Transactional
    public DadosDetalhamentoMedicoDTO atualizarMedico(DadosAtualizacaoMedicoDTO dadosAtualizacaoMedicoDTO) {
       var medico = medicoRepository.getReferenceById(dadosAtualizacaoMedicoDTO.id());
       medico.atualizarMedico(dadosAtualizacaoMedicoDTO);
       return new DadosDetalhamentoMedicoDTO(medico);
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

    @Transactional
    public DadosDetalhamentoMedicoDTO buscarPorID(Long id) {
        var medico = medicoRepository.getReferenceById(id);
        return new DadosDetalhamentoMedicoDTO(medico);
    }

}
