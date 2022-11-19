package med.voli.api.data.dto;

import med.voli.api.data.enumerator.Especialidade;

public record MedicoDTO(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        EnderecoDTO endereco
) {
}
