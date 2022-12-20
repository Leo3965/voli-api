package med.voli.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voli.api.domain.data.dto.PacienteDTO;
import med.voli.api.domain.data.dto.PacienteListDTO;
import med.voli.api.domain.data.dto.PacienteUpdateDTO;
import med.voli.api.domain.data.entity.Paciente;
import med.voli.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public void registry(@RequestBody @Valid PacienteDTO dto) {
        repository.save(new Paciente(dto));
    }

    @GetMapping
    public Page<PacienteListDTO> list(Pageable pageable) {
        return repository.findAllByActiveTrue(pageable).map(PacienteListDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid PacienteUpdateDTO dto) {
        var paciente = repository.getReferenceById(dto.id());
        paciente.update(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void remover(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.deactive();
    }

}