package med.voli.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voli.api.data.dto.MedicoDTO;
import med.voli.api.data.dto.MedicoListDTO;
import med.voli.api.data.dto.MedicoUpdateDTO;
import med.voli.api.data.entity.Medico;
import med.voli.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void registration(@RequestBody @Valid MedicoDTO medico) {
        var dto = new Medico(medico);
        repository.save(dto);
    }

    @GetMapping
    public Page<MedicoListDTO> list(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
     return repository.findAllByActiveTrue(pageable).map(MedicoListDTO::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid MedicoUpdateDTO dto){
        var medico = repository.getReferenceById(dto.id());
        medico.update(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delelete(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.deactivate();
    }
}
