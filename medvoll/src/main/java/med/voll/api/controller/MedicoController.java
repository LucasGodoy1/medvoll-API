package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.domain.dto.DadosAtualizacaoMedicoDTO;
import med.voll.api.domain.dto.DadosCadastroMedicoDTO;
import med.voll.api.domain.dto.DadosDetalhamentoMedicoDTO;
import med.voll.api.domain.dto.ListarMedicoDTO;
import med.voll.api.domain.service.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RequiredArgsConstructor
@RestController
@RequestMapping("medicos/")
public class MedicoController {
    private final MedicoService medicoService;


    @PostMapping("cadastro")
    public ResponseEntity<DadosDetalhamentoMedicoDTO> cadastrarMedico(@RequestBody  @Valid DadosCadastroMedicoDTO dadosCadastroMedicoDTO, UriComponentsBuilder uriBuilder) {
       var medico = medicoService.salvarMedico(dadosCadastroMedicoDTO);

       var uri = uriBuilder.path("/medicos={id}").buildAndExpand(medico.id()).toUri();
       return ResponseEntity.created(uri).body(medico);
    }

    @GetMapping("id={id}")
    public ResponseEntity<DadosDetalhamentoMedicoDTO> buscarMedico(@PathVariable Long id) {
        return ResponseEntity.ok(medicoService.buscarPorID(id));
    }

    @GetMapping("listarMedicos")
    public ResponseEntity<Page<ListarMedicoDTO>> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
            var page = medicoService.listarMedicos(pageable);
        return ResponseEntity.ok(page);
    }//localhost:8080/medicos/listarMedicos?size=5&page=2&sort=nome,desc

    @PutMapping("atualizardadosmedico")
    public ResponseEntity<DadosDetalhamentoMedicoDTO> atualizar(@RequestBody @Valid DadosAtualizacaoMedicoDTO dadosAtualizacaoMedicoDTO) {
        var dadosDetalhamentoMedicoDTO = medicoService.atualizarMedico(dadosAtualizacaoMedicoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(dadosDetalhamentoMedicoDTO);
    }

    @DeleteMapping("deletarmedicos={id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        medicoService.deletePorID(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("excluirmedico={id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        medicoService.desativarPorID(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }





}
