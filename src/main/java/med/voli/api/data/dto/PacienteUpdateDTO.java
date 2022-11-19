package med.voli.api.data.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record PacienteUpdateDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        @Valid EnderecoDTO endereco
) {
}
