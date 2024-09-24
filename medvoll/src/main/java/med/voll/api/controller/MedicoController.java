package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.dto.DadosCadastroMedicoDTO;
import med.voll.api.dto.ListarMedicoDTO;
import med.voll.api.entity.Medico;
import med.voll.api.service.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    } //localhost:8080/medicos/listarMedicos?size=5&page=2&sort=nome,desc

    @GetMapping("listarMedicos")
    ResponseEntity<Page<ListarMedicoDTO>> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {

        return ResponseEntity.ok(medicoService.listarMedicos(pageable));
    }



}
