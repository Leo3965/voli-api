package med.voli.api.domain.data.dto;

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
