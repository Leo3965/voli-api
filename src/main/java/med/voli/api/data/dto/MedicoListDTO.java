package med.voli.api.data.dto;

import med.voli.api.data.entity.Medico;
import med.voli.api.data.enumerator.Especialidade;

public record MedicoListDTO(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {
    public MedicoListDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
