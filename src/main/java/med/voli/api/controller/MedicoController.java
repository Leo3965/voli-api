package med.voli.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voli.api.domain.data.dto.MedicoDTO;
import med.voli.api.domain.data.dto.MedicoListDTO;
import med.voli.api.domain.data.dto.MedicoUpdateDTO;
import med.voli.api.domain.data.dto.MedicoResponseDTO;
import med.voli.api.domain.data.entity.Medico;
import med.voli.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity enroll(@RequestBody @Valid MedicoDTO medicoDTO, UriComponentsBuilder uriBuilder) {
        var medico =  new Medico(medicoDTO);
        repository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}")
                .buildAndExpand(medico.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new MedicoResponseDTO(medico));
    }

    @GetMapping
    public ResponseEntity<Page<MedicoListDTO>> list(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
     var page = repository.findAllByActiveTrue(pageable).map(MedicoListDTO::new);
     return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid MedicoUpdateDTO dto){
        var medico = repository.getReferenceById(dto.id());
        medico.update(dto);
        return ResponseEntity.ok(new MedicoResponseDTO(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.deactivate();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok().body(new MedicoResponseDTO(medico));
    }
}
