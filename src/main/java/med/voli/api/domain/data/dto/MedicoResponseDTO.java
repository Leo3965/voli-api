package med.voli.api.domain.data.dto;

import med.voli.api.domain.data.entity.Endereco;
import med.voli.api.domain.data.entity.Medico;
import med.voli.api.domain.data.enumerator.Especialidade;

public record MedicoResponseDTO(
        Long id,
        String nome,
        String email,
        String crm,
        String telefone,
        Especialidade especialidade,
        Endereco endereco
) {
    public MedicoResponseDTO(Medico medico) {
        this(
                medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getTelefone(),
                medico.getEspecialidade(),
                medico.getEndereco()
        );
    }
}
