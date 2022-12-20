package med.voli.api.domain.data.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voli.api.domain.data.enumerator.Especialidade;

public record MedicoDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank(message = "E-mail é obrigatório")
        @Email(message = "Formato do email é inválido")
        String email,

        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}", message = "Formato do CRM é inválido")
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull(message = "Dados do endereço são obrigatórios")
        @Valid
        EnderecoDTO endereco
) {
}
