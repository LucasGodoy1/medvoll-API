package med.voll.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.dto.DadosCadastroMedicoDTO;
import med.voll.api.service.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
