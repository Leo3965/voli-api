package med.voli.api.domain.data.dto;

import jakarta.validation.constraints.NotNull;

public record MedicoUpdateDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        String email,
        EnderecoDTO endereco
) {
}
