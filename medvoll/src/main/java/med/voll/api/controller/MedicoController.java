package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.dto.DadosCadastroMedicoDTO;
import med.voll.api.dto.ListarMedicoDTO;
import med.voll.api.entity.Medico;
import med.voll.api.service.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("medicos/")
public class MedicoController {
    private final MedicoService medicoService;


    @PostMapping("cadastrarMedico")
    public ResponseEntity<DadosCadastroMedicoDTO> cadastrarMedico(@RequestBody  @Valid DadosCadastroMedicoDTO dadosCadastroMedicoDTO) {
        medicoService.salvarMedico(dadosCadastroMedicoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dadosCadastroMedicoDTO);
    }

    @GetMapping("listarMedicos")
    ResponseEntity<Page<ListarMedicoDTO>> listarMedicos(Pageable pageable) {

        return ResponseEntity.ok(medicoService.listarMedicos(pageable));
    }



}
