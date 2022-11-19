package med.voli.api.controller;

import jakarta.transaction.Transactional;
import med.voli.api.data.dto.MedicoDTO;
import med.voli.api.data.entity.Medico;
import med.voli.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void registration(@RequestBody MedicoDTO medico) {
        var dto = new Medico(medico);
        repository.save(dto);
    }
}
