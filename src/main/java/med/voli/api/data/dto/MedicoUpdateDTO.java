package med.voli.api.data.dto;

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
